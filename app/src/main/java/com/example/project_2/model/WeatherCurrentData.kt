package com.example.project_2.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherCurrentData(
    val temp_c: Float,
    val humidity: Float,
    val wind_kph: Float,
    val condition: WeatherCurrentMainData,
)