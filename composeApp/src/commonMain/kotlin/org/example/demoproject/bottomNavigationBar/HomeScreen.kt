package com.app.drivein.bottomNavigationBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import demoproject.composeapp.generated.resources.Res
import demoproject.composeapp.generated.resources.banner
import org.jetbrains.compose.resources.painterResource

class HomeScreen {
    @Composable
    fun HomeScreen() {

        // Column Composable,
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
           Row {
                launchingBanner()
           }
        }
    }

    @Composable
    fun launchingBanner(){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .padding(10.dp),
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color(0xFF00A876)
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(0.7f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Your journey starts here.",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Just sit back and relax -",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

                //Spacer(modifier = Modifier.height(12.dp))

                Image(
                    painter = painterResource(Res.drawable.banner), // Replace with your image
                    contentDescription = "Navigation Image",
                    modifier = Modifier
                        .height(100.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .weight(0.3f)
                )
            }

        }
    }
}