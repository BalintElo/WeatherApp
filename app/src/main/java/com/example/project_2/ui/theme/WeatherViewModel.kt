package com.example.project_2.ui.theme
import retrofit2.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_2.model.WeatherData
import com.example.project_2.network.WeatherApi
import kotlinx.coroutines.launch
import java.io.IOException

class WeatherViewModel : ViewModel() {
    var location by mutableStateOf("")
        public set
    var weatherUiState: WeatherUiState by
    mutableStateOf(WeatherUiState.InputRequired)
        private set


    fun getWeatherData() {
        val appid = " 30bb594ccfff41c2a2292436252511 " ; // not the best way to place the api key in a app, but for now it will be okay TODO replace with your key
        viewModelScope.launch {
            weatherUiState = WeatherUiState.Loading
            weatherUiState = try {
                if(location.isEmpty()) {
                    WeatherUiState.Error
                } else {
                    WeatherUiState.Success(WeatherApi.retrofitService.getWeatherData(location, appid))
                }
            } catch (e: IOException) {
                WeatherUiState.Error
            } catch (e: HttpException) {
                WeatherUiState.Error
            }
        }
    }}