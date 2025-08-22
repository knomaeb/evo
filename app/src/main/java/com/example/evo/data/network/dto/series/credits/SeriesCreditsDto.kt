package com.example.evo.data.network.dto.series.credits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesCreditsDto(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("cast")
    val cast: List<Cast>? = null,
    @SerialName("crew")
    val crew: List<Crew>? = null,
)