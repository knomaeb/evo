package com.example.evo.data.network.mapper

import com.example.evo.data.local.entities.trending.TrendingEntity
import com.example.evo.domain.model.trending.Trending
import com.example.philm.data.network.dto.trending.TrendingResult

fun TrendingResult.toTrending(): Trending =
    Trending(
        backdropPath = backdropPath,
        id = id,
        mediaType = mediaType,
        name = name,
        posterPath = posterPath,
        title = title,
    )

fun TrendingEntity.toTrending(): Trending =
    Trending(
        backdropPath = backdropPath,
        id = trendingId,
        mediaType = mediaType,
        name = name,
        posterPath = posterPath,
        title = title,
    )

fun Trending.toTrendingEntity(): TrendingEntity =
    TrendingEntity(
        backdropPath = backdropPath,
        mediaType = mediaType,
        name = name,
        posterPath = posterPath,
        title = title,
        trendingId = id,
    )