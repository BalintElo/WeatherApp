package com.example.project_2.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherData(val current: WeatherCurrentData,val temp_c: Float, val condition: String) {
// will be extended and changed in next session when getting data over http
}
