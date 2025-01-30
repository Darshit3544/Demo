package org.example.demoproject.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import demoproject.composeapp.generated.resources.Res
import demoproject.composeapp.generated.resources.sedan
import org.jetbrains.compose.resources.painterResource

class RideConfirmationScreen {
    @Composable
    fun DriverArrivalScreen(navController: NavHostController) {

        val scrollState = rememberScrollState()

        Column(modifier = Modifier.fillMaxSize().padding(start = 8.dp)) {
            mapView(navController)
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp).weight(1f)
                    .verticalScroll(scrollState)
            ) {
                DriverArrivalHeader()
                Spacer(modifier = Modifier.height(8.dp))
                RideDetailsCard()
                Spacer(modifier = Modifier.height(16.dp))
                //AdditionalOptions()

                ShowExtraInfo()

                Spacer(modifier = Modifier.height(16.dp))
                //BottomButtons(navController)
            }
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, bottom = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
            ) {
                BottomButtons(navController)
            }

        }


    }

    private @Composable
    fun ShowExtraInfo() {
        Card(
            elevation = 4.dp,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                ExtraInfo(
                    "Home 4.3km",
                    "3342 Hill Street, Jacksonville, FL 32202",
                    "Change",
                    Icons.Default.Home
                )
                ExtraInfo(
                    "Share this trip status",
                    "Ride's details",
                    "Share",
                    Icons.Default.Share
                )
            }
        }
    }

    @Composable
    fun DriverArrivalHeader() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Driver arriving soon", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Button(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6B63FF))
            ) {
                Text(text = "2 mins", color = Color.White)
            }
        }
    }

    @Composable
    fun RideDetailsCard() {
        Card(
            elevation = 4.dp,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.sedan),
                        contentDescription = "Driver Image",
                        modifier = Modifier.size(48.dp).clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = "Joshua", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Text(text = "⭐ 4.9", fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column(horizontalAlignment = Alignment.End) {
                        Text(text = "382-SOD23", fontWeight = FontWeight.Bold)
                        Text(text = "BMW-R2", color = Color.Gray)
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(0.8f),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
                    ) {
                        Text(text = "💬 Chat with driver")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Phone, contentDescription = "Call")
                    }
                }
            }
        }
    }

    @Composable
    fun ExtraInfo(
        label: String,
        time: String,
        action: String,
        image: ImageVector
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = image, // Replace with actual image resource
                contentDescription = "Car Icon",
                modifier = Modifier.size(20.dp),
                tint = Color(0xFF665FF0)
            )
            Spacer(modifier = Modifier.width(8.dp))
            /* RadioButton(
                 selected = selected,
                 onClick = onSelect
             )*/
            Row {
                Column(modifier = Modifier.weight(1.0f)) {
                    Text(
                        text = label,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(text = time, fontSize = 13.sp, color = Color.Gray)
                }

                Text(
                    text = action,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF665FF0)
                )
            }

        }
    }

    @Composable
    fun AdditionalOptions() {
        Card(
            elevation = 4.dp,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "🏠 Home 4.3km", fontWeight = FontWeight.Bold)
                Text(
                    text = "3342 Hill Street, Jacksonville, FL 32202",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = "Change or Add",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    modifier = Modifier.clickable {})
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "$12.32", fontWeight = FontWeight.Bold)
                Text(text = "MasterCard 2321", fontSize = 14.sp, color = Color.Gray)
                Text(
                    text = "Change",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    modifier = Modifier.clickable {})
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Share this trip status", fontWeight = FontWeight.Bold)
                Text(
                    text = "Share",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    modifier = Modifier.clickable {})
            }
        }
    }

    @Composable
    fun BottomButtons(navController: NavHostController) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text(text = "Cancel trip", color = Color.White)
            }
            Button(
                onClick = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6B63FF)),
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text(text = "Home", color = Color.White)
            }
        }
    }

}