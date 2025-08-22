package com.example.evo.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.evo.data.local.dao.MovieDetailsDao
import com.example.evo.data.local.dao.MoviesDao
import com.example.evo.data.local.dao.RemoteKeyDao
import com.example.evo.data.local.dao.SeriesDao
import com.example.evo.data.local.dao.SeriesDetailsDao
import com.example.evo.data.local.dao.TrendingDao
import com.example.evo.data.local.dao.UpdateTimeDao
import com.example.evo.data.local.dao.UserListDao
import com.example.evo.data.local.entities.RemoteKey
import com.example.evo.data.local.entities.UpdateTime
import com.example.evo.data.local.entities.movie.NowPlayingMoviesEntity
import com.example.evo.data.local.entities.movie.PopularMoviesEntity
import com.example.evo.data.local.entities.movie.UpcomingMoviesEntity
import com.example.evo.data.local.entities.movie.details.MovieDetailsEntity
import com.example.evo.data.local.entities.movie.details.MovieRecommendationCrossRef
import com.example.evo.data.local.entities.movie.details.MovieRecommendationEntity
import com.example.evo.data.local.entities.series.PopularSeriesEntity
import com.example.evo.data.local.entities.series.TopRatedSeriesEntity
import com.example.evo.data.local.entities.series.details.SeriesDetailsEntity
import com.example.evo.data.local.entities.series.details.SeriesRecommendationCrossRef
import com.example.evo.data.local.entities.series.details.SeriesRecommendationEntity
import com.example.evo.data.local.entities.series.details.SeriesSeasonCrossRef
import com.example.evo.data.local.entities.series.details.SeriesSeasonEntity
import com.example.evo.data.local.entities.trending.TrendingEntity

@Database(
    entities = [
        PopularMoviesEntity::class, UpcomingMoviesEntity::class, NowPlayingMoviesEntity::class,
        PopularSeriesEntity::class, TopRatedSeriesEntity::class, TrendingEntity::class,
        RemoteKey::class, UpdateTime::class, MovieDetailsEntity::class,
        MovieRecommendationCrossRef::class, MovieRecommendationEntity::class, SeriesDetailsEntity::class,
        SeriesSeasonEntity::class, SeriesSeasonCrossRef::class, SeriesRecommendationEntity::class,
        SeriesRecommendationCrossRef::class,
    ],
    version = 1,
)
abstract class EvoDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao

    abstract fun seriesDao(): SeriesDao

    abstract fun trendingDao(): TrendingDao

    abstract fun userListDao(): UserListDao

    abstract fun remoteKeyDao(): RemoteKeyDao

    abstract fun updateTimeDao(): UpdateTimeDao

    abstract fun movieDetailsDao(): MovieDetailsDao

    abstract fun seriesDetailsDao(): SeriesDetailsDao
}