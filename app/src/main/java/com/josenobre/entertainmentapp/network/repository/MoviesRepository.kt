package com.josenobre.entertainmentapp.network.repository

import androidx.lifecycle.LiveData
import com.josenobre.entertainmentapp.network.api.ApiService
import com.josenobre.entertainmentapp.network.api.adapter.AppExecutors
import com.josenobre.entertainmentapp.network.api.adapter.NetworkBoundResource
import com.josenobre.entertainmentapp.network.api.adapter.Resource
import com.josenobre.entertainmentapp.network.api.responses.MovieResult
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val apiService: ApiService, private val appExecutors: AppExecutors) {

    fun getPopularMovies(): LiveData<Resource<MovieResult>> {
        return object : NetworkBoundResource<MovieResult>(appExecutors) {
            override fun createCall() = apiService.getPopularMovies()
        }.asLiveData()
    }
}