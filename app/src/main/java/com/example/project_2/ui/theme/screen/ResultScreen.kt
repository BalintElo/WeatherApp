package com.example.project_2.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.project_2.model.WeatherData
@Composable
fun ResultScreen(weatherData: WeatherData, modifier: Modifier = Modifier
    .fillMaxSize().wrapContentSize(Alignment.Center)) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = weatherData.temp_c.toString())
        Text(text = weatherData.condition)
    }
}