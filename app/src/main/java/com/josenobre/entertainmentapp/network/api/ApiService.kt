package com.josenobre.entertainmentapp.network.api

import androidx.lifecycle.LiveData
import com.josenobre.entertainmentapp.network.api.responses.MovieResult
import com.josenobre.entertainmentapp.network.model.ApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("movie/popular?")
    abstract fun getPopularMovies(): LiveData<ApiResponse<MovieResult>>

}