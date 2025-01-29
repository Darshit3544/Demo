package org.example.demoproject.UI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import demoproject.composeapp.generated.resources.Res
import demoproject.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun whereToLayout(navController: NavController) {
    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier.padding(8.dp).fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }

            androidx.compose.material.Text(
                text = "Select Location",
                fontSize = 25.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
        }
        LocationScreen(navController)
    }
}

@Composable
fun LocationScreen(navController: NavController) {
    val destination = remember { mutableStateOf("") }
    val currentLocation = remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
    ) {

        // Back Button and Current Location Input
        Row {
            /*IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }*/

            Column {

                TextField(
                    value = currentLocation.value,
                    onValueChange = {
                        currentLocation.value = it
                    },
                    modifier = Modifier // Set a fixed height
                        .fillMaxWidth()
                        .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(10.dp)),
                    shape = MaterialTheme.shapes.medium,
                    colors = TextFieldDefaults.colors(
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.White
                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(Res.drawable.navigation),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Current Location",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                        )
                    },
                    singleLine = true,
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Destination Input
                OutlinedTextField(
                    value = destination.value,
                    onValueChange = {
                        destination.value = it
                    },
                    placeholder = { Text("Where to?") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(Res.drawable.location),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = Color.Red
                        )
                    },
                    modifier = Modifier // Set a fixed height
                        .fillMaxWidth()
                        .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(10.dp)),
                    shape = MaterialTheme.shapes.medium,
                    colors = TextFieldDefaults.colors(
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color.LightGray,
                        unfocusedContainerColor = Color.LightGray
                    ),
                )
            }

        }



        Spacer(modifier = Modifier.height(16.dp))

        // Saved Places
        Text("Saved places", fontWeight = FontWeight.Bold, fontSize = 20.sp)

        SavedPlaceItem(
            "Work",
            "2.3km",
            "1671 North Avenue, Tucson, L9D6J3",
            Icons.Default.Phone,
            true,navController
        )
        SavedPlaceItem(
            "Home",
            "9.6km",
            "1234 Desert Road, Hamilton, P7B2Y8",
            Icons.Default.Home,
            true,
            navController
        )
        SavedPlaceItem(
            "Add New",
            "",
            "Save your favorite location",
            Icons.Default.AddCircle,
            false,
            navController
        )

        // Frequent Destinations
        Text("Frequent destinations",  fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))

        FrequentDestinationItem("Play Ground", "9.6km", "37 Golden Orchard dr, Hamilton",Icons.Default.LocationOn,false)
        FrequentDestinationItem("Library", "2.4km" ,"100 west 5 st, Hamilton",Icons.Default.LocationOn,false)
    }
}

@Composable
fun SavedPlaceItem(
    title: String,
    kms: String,
    address: String,
    icon: ImageVector,
    isEdit: Boolean,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("ConfirmRide")
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = title, tint = Color(0xFF665FF0))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(title, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(kms, fontSize = 12.sp)
                }
                Text(address, color = Color.Gray, modifier = Modifier.padding(top = 3.dp))
            }
            if (isEdit)
                Icon(
                    painter = painterResource(Res.drawable.edit),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp).padding(start = 10.dp).weight(1.0f),
                    tint = Color.Gray
                )
        }

        Divider(
            color = Color.LightGray,  // Line color
            thickness = 1.dp,
            modifier = Modifier.padding(top = 7.dp)// Thickness of the line
        )
    }


}

@Composable
fun FrequentDestinationItem(title: String,
                            kms: String,
                            address: String,
                            icon: ImageVector,
                            isEdit: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = title, tint = Color(0xFF665FF0))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(title, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(kms, fontSize = 12.sp)
                }
                Text(address, color = Color.Gray, modifier = Modifier.padding(top = 3.dp))
            }
            if (isEdit)
                Icon(
                    painter = painterResource(Res.drawable.edit),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp).padding(start = 10.dp).weight(1.0f),
                    tint = Color.Gray
                )
        }

        Divider(
            color = Color.LightGray,  // Line color
            thickness = 1.dp,
            modifier = Modifier.padding(top = 7.dp)// Thickness of the line
        )
    }
}
