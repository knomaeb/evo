package com.example.evo.data.network.dto.movie.credits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieCreditsDto(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("cast")
    val cast: List<Cast>? = null,
    @SerialName("crew")
    val crew: List<Crew>? = null,
)