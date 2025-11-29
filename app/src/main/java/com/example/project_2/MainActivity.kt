package com.example.project_2
import com.example.project_2.ui.theme.WeatherViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project_2.ui.theme.screen.HomeScreen
import com.example.project_2.ui.theme.Project2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val weatherViewModel: WeatherViewModel = viewModel()
            Project2Theme {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(
                            navController = navController,
                            weatherViewModel = weatherViewModel,
                            weatherUiState = weatherViewModel.weatherUiState
                        )
                    }
                    composable("imprint") {
                        ImprintScreen(navController)
                    }
                }
            }
        }
    }
}


@Composable
fun ImprintScreen(
    navController: NavController,
    modifier:Modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)

){
    Column(modifier=modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ){
        Text(
            text = "App developed by Balint Elo"
        )
        Button(onClick = {
            navController.navigate("home")
        }) {
            Text("home")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Project2Theme {
        // HomeScreen()
    }
}