package com.example.project_2.ui.theme

import com.example.project_2.model.WeatherData

sealed interface WeatherUiState {
    data class Success(val weatherData: WeatherData) : WeatherUiState
    object Error : WeatherUiState
    object Loading : WeatherUiState
    object InputRequired : WeatherUiState
}