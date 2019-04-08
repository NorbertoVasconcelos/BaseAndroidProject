package com.josenobre.entertainmentapp.network.model

import androidx.annotation.NonNull
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movie(
    @field:SerializedName("id")
    @field:Expose
    @field:NonNull
    val id: Int, @field:SerializedName(value = "poster_path")
    var posterUrl: String, var rating: Double?, @field:SerializedName(value = "release_date")
    var releaseYear: String, var title: String, var adult: Boolean?,
    var overview: String, @field:SerializedName(value = "original_title")
    var originalTitle: String, @field:SerializedName(value = "original_language")
    var originalLanguage: String, @field:SerializedName(value = "backdrop_path")
    var backdropPath: String,
    var popularity: Double?, @field:SerializedName(value = "vote_count")
    var voteCount: Int?, var video: Boolean?, @field:SerializedName(value = "vote_average")
    var voteAverage: Double?, @field:SerializedName(value = "genre_ids")
    var genreIds: List<Int>
)