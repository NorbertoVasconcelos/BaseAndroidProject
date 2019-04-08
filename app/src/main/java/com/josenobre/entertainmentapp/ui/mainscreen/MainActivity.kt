package com.josenobre.entertainmentapp.ui.mainscreen

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.josenobre.entertainmentapp.R
import com.josenobre.entertainmentapp.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun layoutToInflate() = R.layout.activity_main
    override fun defineViewModel() =
        ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

    override fun doOnCreated() {
        viewModel.getPopularMovies().observe(this, Observer {
            Toast.makeText(applicationContext, it.data?.totalResults.toString(), Toast.LENGTH_LONG).show()
        })
    }
}
