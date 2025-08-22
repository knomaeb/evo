package com.example.evo.data.network

import com.example.evo.BuildConfig
import com.example.evo.core.utils.TimeWindow
import com.example.evo.data.network.dto.movie.MovieRangeResponseDto
import com.example.evo.data.network.dto.movie.credits.MovieCreditsDto
import com.example.evo.data.network.dto.movie.details.MovieDetailsDto
import com.example.evo.data.network.dto.search.SearchMovieResponse
import com.example.evo.data.network.dto.series.SeriesResponseDto
import com.example.evo.data.network.dto.series.details.SeriesDetailsDto
import com.example.evo.data.network.dto.trending.TrendingResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkService {

    @Headers(
        "accept: application/json",
        "Authorization: Bearer ${BuildConfig.TMDB_API_KEY}"
    )
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US",
    ) : MovieRangeResponseDto

    @Headers(
        "accept: application/json",
        "Authorization: Bearer ${BuildConfig.TMDB_API_KEY}"
    )
    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US",
    ) : MovieRangeResponseDto

    @Headers(
        "accept: application/json",
        "Authorization: Bearer ${BuildConfig.TMDB_API_KEY}"
    )
    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US",
    ): MovieRangeResponseDto

    @Headers(
        "accept: application/json",
        "Authorization: Bearer ${BuildConfig.TMDB_API_KEY}"
    )
    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US",
    ) : MovieRangeResponseDto

    @Headers(
        "accept: application/json",
        "Authorization: Bearer ${BuildConfig.TMDB_API_KEY}"
    )
    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int,
        @Query("append_to_response") appendToResponse: String? = null,
        @Query("language") language: String = "en-US",
    ) : MovieDetailsDto

    @Headers(
        "accept: application/json",
        "Authorization: Bearer ${BuildConfig.TMDB_API_KEY}"
    )
    @GET("movie/{movieId}/credits")
    suspend fun getMovieCredits(
        @Path("movieId") movieId: Int,
        @Query("language") language: String = "en-US",
    ) : MovieCreditsDto

    @Headers(
        "accept: application/json",
        "Authorization: Bearer ${BuildConfig.TMDB_API_KEY}"
    )
    @GET("search/movie")
    suspend fun getSearchMovie(
        @Query("query") query: String,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US",
    ) : SearchMovieResponse

    @Headers(
        "accept: application/json",
        "Authorization: Bearer ${BuildConfig.TMDB_API_KEY}"
    )
    @GET("trending/all/{time_window}")
    suspend fun getTrendingMovie(
        @Path("time_window") timeWindow: String = TimeWindow.day.name,
        @Query("language") language: String = "en-US",
    ) : TrendingResponse

    @Headers(
        "accept: application/json",
        "Authorization: Bearer ${BuildConfig.TMDB_API_KEY}"
    )
    @GET("tv/popular")
    suspend fun getPopularSeries(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US",
    ) : SeriesResponseDto

    @Headers(
        "accept: application/json",
        "Authorization: Bearer ${BuildConfig.TMDB_API_KEY}"
    )
    @GET("tv/top_rated")
    suspend fun getTopRatedSeries(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US",
    ) : SeriesResponseDto

    @Headers(
        "accept: application/json",
        "Authorization: Bearer ${BuildConfig.TMDB_API_KEY}"
    )
    @GET("tv/{series_id}")
    suspend fun getSeriesDetails(
        @Path("series_id") seriesId: Int,
        @Query("append_to_response") appendToResponse: String? = null,
        @Query("language") language: String = "en-US",
    ) : SeriesDetailsDto

}