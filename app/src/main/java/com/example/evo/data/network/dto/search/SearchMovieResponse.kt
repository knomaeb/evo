package com.example.evo.data.network.dto.search

import com.example.evo.data.network.dto.movie.MovieResult
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchMovieResponse(
    @SerialName("page")
    val page: Int? = null,

    @SerialName("total_pages")
    val totalPages: Int? = null,

    @SerialName("results")
    val results: List<MovieResult>? = null,

    @SerialName("total_results")
    val totalResults: Int? = null
)
