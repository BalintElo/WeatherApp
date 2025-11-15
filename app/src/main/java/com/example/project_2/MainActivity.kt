package com.example.project_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project_2.ui.theme.Project2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Project2Theme {
                NavHost(navController = navController,startDestination = "home") {
                    composable("home") {
                        HomeScreen(navController = navController)
                    }
                    composable("Imprint") {
                        ImprintScreen(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController,modifier: Modifier = Modifier.fillMaxSize().wrapContentSize((Alignment.Center))) {
    var result by remember{ mutableStateOf(1) }
    var locationValue by remember{ mutableStateOf("")}
    Column( modifier = modifier  ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(
            text = "Hello $result $locationValue"
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = locationValue,
            onValueChange = { locationValue = it },
            label = { Text(text = "Location") },
            placeholder = { Text(text = "Enter a location to request weather update") },
            leadingIcon = { Icon(Icons.Rounded.LocationOn, contentDescription = "Location icon") }
        )

        Button( onClick = { result=(1..6).random() }) {
            Text(text = stringResource(id = R.string.search))
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