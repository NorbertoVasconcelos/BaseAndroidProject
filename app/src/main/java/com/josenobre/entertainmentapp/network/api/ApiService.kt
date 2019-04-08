package com.josenobre.entertainmentapp.network.api

import androidx.lifecycle.LiveData
import com.josenobre.entertainmentapp.network.api.responses.MovieResponse
import com.josenobre.entertainmentapp.network.model.ApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("discover/movie?sort_by=popularity.desc")
    fun getPopularMovies(): LiveData<ApiResponse<MovieResponse>>

}