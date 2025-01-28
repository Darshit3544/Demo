package org.example.demoproject

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import org.example.demoproject.UI.BottomNavigationView
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {

            GreetingFun("Android",Modifier)

    }
}

@Composable
fun GreetingFun(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    val navController = rememberNavController()
    val bottomNavigationView = BottomNavigationView()

    Surface{
        Scaffold(
            // Bottom navigation
            bottomBar = {
                    bottomNavigationView.BottomNavigationBar(navController = navController)
            }, content = { padding ->
                // Navhost: where screens are placed
                bottomNavigationView.NavHostContainer(navController = navController, padding = padding)
            }
        )


    }
}

@Composable
fun SharedSplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Welcome to MyApp", fontSize = 24.sp)
    }
}