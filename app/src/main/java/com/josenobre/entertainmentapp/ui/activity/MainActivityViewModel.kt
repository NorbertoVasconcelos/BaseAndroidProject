package com.josenobre.entertainmentapp.ui.activity

import androidx.lifecycle.ViewModel
import com.josenobre.entertainmentapp.network.repository.MoviesRepository
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val moviesRepository: MoviesRepository) : ViewModel() {

    fun retrievePopularMovies() = moviesRepository.retrievePopularMovies()

}