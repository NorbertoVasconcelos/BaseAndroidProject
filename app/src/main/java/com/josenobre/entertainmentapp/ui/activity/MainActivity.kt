package com.josenobre.entertainmentapp.ui.activity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.josenobre.entertainmentapp.R
import com.josenobre.entertainmentapp.network.api.adapter.Status
import com.josenobre.entertainmentapp.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun layoutToInflate() = R.layout.activity_main
    override fun defineViewModel() =
        ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

    override fun doOnCreated() {
        viewModel.retrievePopularMovies().observe(this, Observer { result ->

            result?.let {
                when (it.status) {
                    Status.SUCCESS -> {
                        result.data?.let {
                            //bind data to recycler view and show here
                        }
                    }
                    Status.LOADING -> {
                        // show loading
                    }
                    Status.ERROR -> {
                        // show errors outcomes
                    }
                }
            }
        })
    }
}
