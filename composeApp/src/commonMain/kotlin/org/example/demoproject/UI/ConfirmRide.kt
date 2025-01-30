package org.example.demoproject.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import demoproject.composeapp.generated.resources.Res
import demoproject.composeapp.generated.resources.cabriolet
import demoproject.composeapp.generated.resources.hatchback
import demoproject.composeapp.generated.resources.map_direction
import demoproject.composeapp.generated.resources.minivan
import demoproject.composeapp.generated.resources.sedan
import demoproject.composeapp.generated.resources.suv
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ConfirmRide(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        mapView(navController)

        val scrollState = rememberScrollState()

        Column(modifier = Modifier.weight(1f).verticalScroll(scrollState)) {
            RideOptionScreen(navController)
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { /*navController.navigate("home"){
                popUpTo("home"){inclusive = true}
            }*/
                    navController.navigate("RideConfirmation")
                },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF665FF0) // Set background color to blue
                )
            ) {
                Text(
                    "Book Now",
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.background(Color(0xFF665FF0))
                )
            }
        }
    }
}

data class RideOption(
    val label: String,
    val time: String,
    val price: Double,
    val imageRes: DrawableResource
)

@Composable
fun RideOptionScreen(navController: NavHostController) {
    val rideOptions = listOf(
        RideOption("Standard 4-seat", "4:23 PM - 6 min away", 12.32, Res.drawable.hatchback),
        RideOption("Standard 5-seat", "4:33 PM - 16 min away", 20.70, Res.drawable.sedan),
        RideOption("Premium 4-seat", "4:29 PM - 12 min away", 22.12, Res.drawable.cabriolet),
        RideOption("SUV 6-seat", "4:37 PM - 20 min away", 18.50, Res.drawable.suv),
        RideOption("SUV 5-seat", "4:27 PM - 10 min away", 21.50, Res.drawable.suv),
        RideOption("MiniVan 8 - seat", "4:19 PM - 2 min away", 28.90, Res.drawable.minivan)
    )
    val selectedOption = remember { mutableStateOf(rideOptions[0]) }

    Column(modifier = Modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp)) {
        rideOptions.forEach { (label, time, price, image) ->
            RideOptionItem(
                label = label,
                time = time,
                price = price,
                image = image,
                selected = label == selectedOption.value.label,
                onSelect = { selectedOption.value = RideOption(label, time, price, image) }
            )
        }


    }
}

@Composable
fun RideOptionItem(
    label: String,
    time: String,
    price: Double,
    image: DrawableResource,
    selected: Boolean,
    onSelect: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect() }
            .background(
                if (selected) Color.LightGray else Color.White,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(image), // Replace with actual image resource
            contentDescription = "Car Icon",
            modifier = Modifier.size(40.dp),
            tint = Color(0xFF665FF0)
        )
        Spacer(modifier = Modifier.width(12.dp))
        /* RadioButton(
             selected = selected,
             onClick = onSelect
         )*/
        Spacer(modifier = Modifier.width(12.dp))
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
                text = "$${price}",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

    }
}

@Composable
fun mapView(navController: NavHostController) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }

            Text(
                text = "Confirm Ride",
                fontSize = 25.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
        }

        Image(
            painter = painterResource(Res.drawable.map_direction), // Replace with your image
            contentDescription = "Map Image",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}