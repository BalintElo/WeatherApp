package com.example.project_2.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.project_2.R
import com.example.project_2.ui.theme.WeatherUiState
import com.example.project_2.ui.theme.WeatherViewModel

@Composable
fun InputScreen(navController: NavController, weatherViewModel:
WeatherViewModel, modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)){

    var locationValue by remember{ mutableStateOf("")}
    Column( modifier = modifier  ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(
            text = "Hello  $locationValue"
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = locationValue,
            onValueChange = { locationValue = it },
            label = { Text(text = "Location") },
            placeholder = { Text(text = "Enter a location to request weather update") },
            leadingIcon = { Icon(Icons.Rounded.LocationOn, contentDescription = "Location icon") }

        )

        Button(onClick = {
            weatherViewModel.getWeatherData()
        }) {
            Text(stringResource(R.string.search))
        }


        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("Imprint")
            }
        ){

            Text("Imprint")
        }


    }
}
@Composable
fun HomeScreen(
    navController: NavController,
    weatherViewModel: WeatherViewModel = viewModel(),
    weatherUiState: WeatherUiState,
    modifier: Modifier = Modifier
) {
    when (weatherUiState) {
// is WeatherUiState.Loading -> LoadingScreen(modifier)
        is WeatherUiState.Success -> ResultScreen(weatherUiState.weatherData, modifier)
/// is WeatherUiState.Error -> ErrorScreen(modifier)
        is WeatherUiState.InputRequired -> InputScreen(navController, weatherViewModel)
        else -> InputScreen(navController, weatherViewModel)
    }
}