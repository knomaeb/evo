package com.example.evo.data.network.dto.trending

import com.example.philm.data.network.dto.trending.TrendingResult
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrendingResponse(
    @SerialName("page")
    val page: Int? = null,
    @SerialName("results")
    val results: List<TrendingResult>? = null,
    @SerialName("total_pages")
    val totalPages: Int? = null,
    @SerialName("total_results")
    val totalResults: Int? = null,
)
