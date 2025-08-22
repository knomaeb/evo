package com.example.evo.data.local.entities.series.details

import androidx.room.Entity

@Entity(primaryKeys = ["seriesId", "recommendationId"])
data class SeriesRecommendationCrossRef(
    val seriesId: Int,
    val recommendationId: Int,
)
