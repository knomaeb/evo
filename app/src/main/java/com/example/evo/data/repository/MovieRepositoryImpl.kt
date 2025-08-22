package com.example.evo.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.evo.data.local.database.EvoDatabase
import com.example.evo.data.local.entities.list.UserListEntity
import com.example.evo.data.local.entities.movie.NowPlayingMoviesEntity
import com.example.evo.data.local.entities.movie.PopularMoviesEntity
import com.example.evo.data.local.entities.movie.UpcomingMoviesEntity
import com.example.evo.data.local.entities.series.PopularSeriesEntity
import com.example.evo.data.local.entities.series.TopRatedSeriesEntity
import com.example.evo.data.network.NetworkService
import com.example.evo.data.network.mediator.NowPlayingMoviesRemoteMediator
import com.example.evo.data.network.mediator.PopularMoviesRemoteMediator
import com.example.evo.data.network.mediator.PopularTvRemoteMediator
import com.example.evo.data.network.mediator.TopRatedTvRemoteMediator
import com.example.evo.data.network.mediator.UpcomingMoviesRemoteMediator
import com.example.evo.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class MovieRepositoryImpl(
    private val movieApi: NetworkService,
    private val database: EvoDatabase,
) : MovieRepository {

    override suspend fun getList(
        listId: Int,
        language: String,
        page: Int,
    ): Flow<PagingData<UserListEntity>> =
        Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            remoteMediator =
                UserListRemoteMediator(
                    api = movieApi,
                    database = database,
                    listId = listId,
                    language = language,
                    page = page,
                ),
            pagingSourceFactory = {
                database.userListDao().pagingSource()
            },
        ).flow

    override suspend fun getNowPlayingMovies(
        language: String,
        page: Int,
        region: String?,
    ): Flow<PagingData<NowPlayingMoviesEntity>> =
        Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            remoteMediator =
                NowPlayingMoviesRemoteMediator(
                    api = movieApi,
                    database = database,
                    language = language,
                    page = page,
                ),
            pagingSourceFactory = {
                database.moviesDao().nowPlayingPagingSource()
            },
        ).flow

    override suspend fun getPopularMovies(
        language: String,
        page: Int,
        region: String?,
    ): Flow<PagingData<PopularMoviesEntity>> =
        Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            remoteMediator =
                PopularMoviesRemoteMediator(
                    api = movieApi,
                    database = database,
                    language = language,
                    page = page,
                ),
            pagingSourceFactory = {
                database.moviesDao().popularPagingSource()
            },
        ).flow

    override suspend fun getUpcomingMovies(
        language: String,
        page: Int,
        region: String?,
    ): Flow<PagingData<UpcomingMoviesEntity>> =
        Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            remoteMediator =
                UpcomingMoviesRemoteMediator(
                    api = movieApi,
                    database = database,
                    language = language,
                    page = page,
                ),
            pagingSourceFactory = {
                database.moviesDao().upcomingPagingSource()
            },
        ).flow

    override suspend fun getMovieDetails(
        movieId: Int,
        appendToResponse: String?,
        language: String,
    ): MovieDetailsDto = movieApi.getMovieDetails(movieId, appendToResponse)

    override suspend fun getTrending(
        timeWindow: TimeWindow,
        language: String,
    ): TrendingResponse = movieApi.getTrendingMovie(timeWindow.name)

    override suspend fun getPopularSeries(
        language: String,
        page: Int,
    ): Flow<PagingData<PopularSeriesEntity>> =
        Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            remoteMediator =
                PopularTvRemoteMediator(
                    api = movieApi,
                    database = database,
                    language = language,
                    page = page,
                ),
            pagingSourceFactory = {
                database.seriesDao().popularPagingSource()
            },
        ).flow

    override suspend fun getTopRatedSeries(
        language: String,
        page: Int,
    ): Flow<PagingData<TopRatedSeriesEntity>> =
        Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            remoteMediator =
                TopRatedTvRemoteMediator(
                    api = movieApi,
                    database = database,
                    language = language,
                    page = page,
                ),
            pagingSourceFactory = {
                database.seriesDao().topRatedPagingSource()
            },
        ).flow

    override suspend fun getSeriesDetails(
        seriesId: Int,
        appendToResponse: String?,
        language: String,
    ): SeriesDetailsDto = movieApi.getSeriesDetails(seriesId, appendToResponse, language)

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }
}