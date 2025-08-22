package com.example.evo.data.network.dto.movie.details

import com.example.evo.data.network.dto.movie.MovieResponseDto
import com.example.evo.data.network.dto.movie.credits.MovieCreditsDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsDto(
    @SerialName("original_language")
    val originalLanguage: String? = null,
    @SerialName("imdb_id")
    val imdbId: String? = null,
    @SerialName("video")
    val video: Boolean? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("backdrop_path")
    val backdropPath: String? = null,
    @SerialName("revenue")
    val revenue: Int? = null,
    @SerialName("genres")
    val genres: List<Genre?>? = null,
    @SerialName("popularity")
    val popularity: Double? = null,
    @SerialName("production_countries")
    val productionCountries: List<ProductionCountry?>? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("vote_count")
    val voteCount: Int? = null,
    @SerialName("budget")
    val budget: Int? = null,
    @SerialName("overview")
    val overview: String? = null,
    @SerialName("original_title")
    val originalTitle: String? = null,
    @SerialName("runtime")
    val runtime: Int? = null,
    @SerialName("poster_path")
    val posterPath: String? = null,
    @SerialName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage?>? = null,
    @SerialName("production_companies")
    val productionCompanies: List<ProductionCompany?>? = null,
    @SerialName("release_date")
    val releaseDate: String? = null,
    @SerialName("vote_average")
    val voteAverage: Double? = null,
    @SerialName("belongs_to_collection")
    val belongsToCollection: String? = null,
    @SerialName("tagline")
    val tagline: String? = null,
    @SerialName("adult")
    val adult: Boolean? = null,
    @SerialName("homepage")
    val homepage: String? = null,
    @SerialName("status")
    val status: String? = null,
    // AppendToResponse
    @SerialName("credits")
    val credits: MovieCreditsDto? = null,
    @SerialName("recommendations")
    val recommendations: MovieResponseDto? = null,
)