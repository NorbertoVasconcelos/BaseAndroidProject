package com.josenobre.entertainmentapp.network.api.responses

import com.google.gson.annotations.SerializedName
import com.josenobre.entertainmentapp.network.model.Movie
import java.util.ArrayList

class MovieResponse {

    var page: Int? = null
    var results: List<Movie> = ArrayList()
    @SerializedName(value = "total_results")
    var totalResults: Int? = null
    @SerializedName(value = "total_pages")
    var totalPages: Int? = null

}

