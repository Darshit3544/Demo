package com.app.drivein.bottomNavigationBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class HomeScreen {
    @Composable
    fun HomeScreen() {

        // Column Composable,
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue),
            // Parameters set to place the items in center
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Icon Composable
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "home",
                tint = Color(0xFF0F9D58)
            )
            // Text to Display the current Screen
            Text(text = "Home", color = Color.Black)
        }
    }
}