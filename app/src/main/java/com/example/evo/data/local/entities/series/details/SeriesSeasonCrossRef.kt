package com.example.evo.data.local.entities.series.details

import androidx.room.Entity

@Entity(primaryKeys = ["seriesId", "seasonId"])
data class SeriesSeasonCrossRef(
    val seriesId: Int,
    val seasonId: Int,
)
