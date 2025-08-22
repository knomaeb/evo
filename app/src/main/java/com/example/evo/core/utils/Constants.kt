package com.example.evo.core.utils

object Constants {
    const val BASE_URL = "https://api.themoviedb.org/3/"

    const val STARTING_PAGE_INDEX = 1
    const val PAGING_SIZE = 10

    const val KEY_THEME = "theme"
    const val KEY_LANGUAGE = "language"
    const val KEY_IMAGE_QUALITY = "image_quality"
}

enum class TimeWindow {
    day,
    week,
}