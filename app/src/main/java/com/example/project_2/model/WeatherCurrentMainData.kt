package com.example.project_2.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherCurrentMainData(
    val text: String,
)