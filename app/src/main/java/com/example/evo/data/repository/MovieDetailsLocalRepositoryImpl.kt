package com.example.evo.data.repository

import com.example.evo.data.local.database.EvoDatabase
import com.example.evo.data.local.entities.movie.details.MovieDetailsEntity
import com.example.evo.data.local.entities.movie.details.MovieDetailsWithRecommendations
import com.example.evo.data.local.entities.movie.details.MovieRecommendationCrossRef
import com.example.evo.data.local.entities.movie.details.MovieRecommendationEntity
import com.example.evo.domain.repository.MovieDetailsLocalRepository

class MovieDetailsLocalRepositoryImpl(
    database: EvoDatabase,
) : MovieDetailsLocalRepository {
    private val movieDetailsDao = database.movieDetailsDao()

    override suspend fun getCachedMovieDetailsById(id: Int): MovieDetailsWithRecommendations? =
        movieDetailsDao.getMovieDetailsWithRecommendations(id)

    override suspend fun clearCacheById(id: Int) {
        movieDetailsDao.deleteMovieDetailsWithCrossRefs(id)
    }

    override suspend fun saveMovieDetails(
        movieDetails: MovieDetailsEntity,
        recommendations: List<MovieRecommendationEntity>,
        movieRecommendationCrossRefs: List<MovieRecommendationCrossRef>,
    ) {
        movieDetailsDao.upsertMovieDetailsWithRecommendations(
            movieDetails = movieDetails,
            recommendations = recommendations,
            movieRecommendationCrossRefs = movieRecommendationCrossRefs,
        )
    }
}