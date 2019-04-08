import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.josenobre.entertainmentapp.network.api.adapter.AppExecutors
import com.josenobre.entertainmentapp.network.api.adapter.Resource
import com.josenobre.entertainmentapp.network.model.ApiErrorResponse
import com.josenobre.entertainmentapp.network.model.ApiResponse
import com.josenobre.entertainmentapp.network.model.ApiSuccessResponse

abstract class NetworkBoundResource<ResultType, RefreshType>
@MainThread constructor(private val appExecutors: AppExecutors) {

    companion object {
        private val TAG = NetworkBoundResource::class.java.simpleName
    }

    private val result = MediatorLiveData<Resource<ResultType>>()
    private val network = MediatorLiveData<ResultType>()
    private val refresh = MediatorLiveData<Result<RefreshType>>()

    private var refreshCall: LiveData<ApiResponse<RefreshType>>? = null


    init {
        requestFromNetwork()
    }

    private fun requestFromNetwork() {
        val apiResponse = createCall()

        setValue(Resource.loading())

        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)

            when (response) {
                is ApiSuccessResponse -> {
                    appExecutors.diskIO().execute {
                        val responseBody = processResponse(response)
                        saveCallResult(responseBody)

                        appExecutors.mainThread().execute {
                            result.addSource(network) { newData ->
                                setValue(Resource.success(200, newData))
                            }

                            updateNetworkSource(responseBody)
                        }
                    }
                }
                is ApiErrorResponse -> {
                    appExecutors.mainThread().execute {
                        refreshCall = refreshCall()
                        if (response.errorCode == 401 && refreshCall != null) {
                            refresh.addSource(refreshCall!!) {
                                refresh.removeSource(refreshCall!!)
                            }
                        } else {
                            result.addSource(network) { newData ->
                                setValue(Resource.error(response.errorMessage, response.errorCode, newData))
                            }

                            updateNetworkSource(null)
                        }
                    }
                }
            }
        }
    }

    fun asLiveData() = result as LiveData<*>

    @MainThread
    private fun setValue(newValue: Resource<ResultType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    @MainThread
    private fun updateNetworkSource(newValue: ResultType?) {
        network.value = newValue
    }

    @MainThread
    protected open fun refreshCall(): LiveData<ApiResponse<RefreshType>>? {
        return null
    }

    @WorkerThread
    protected open fun processResponse(response: ApiSuccessResponse<ResultType>) = response.body

    @WorkerThread
    protected open fun saveCallResult(data: ResultType?) {

    }

    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<ResultType>>
}