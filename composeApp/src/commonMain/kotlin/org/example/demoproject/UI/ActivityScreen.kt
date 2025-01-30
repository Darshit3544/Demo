package org.example.demoproject.UI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import demoproject.composeapp.generated.resources.Res
import demoproject.composeapp.generated.resources.cabriolet
import demoproject.composeapp.generated.resources.hatchback
import demoproject.composeapp.generated.resources.minivan
import demoproject.composeapp.generated.resources.search
import demoproject.composeapp.generated.resources.sedan
import demoproject.composeapp.generated.resources.suv
import org.example.demoproject.UI.HomeScreen.SearchStateModel
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

class ActivityScreen {
    @Composable
    fun SearchScreen() {
        UserActivityScreen(dummyRides)
    }

    // Data class for ride details
    data class Ride(
        val name: String,
        val date: String,
        val route: String,
        val imageRes: DrawableResource
    )

    val dummyRides = listOf(
        Ride("John Doe", "2023-09-15", "Downtown to Uptown", Res.drawable.cabriolet),
        Ride("Jane Smith", "2023-09-12", "Central Park to Times Square", Res.drawable.sedan),
        Ride("Tom Johnson", "2023-09-10", "Broadway to Wall Street", Res.drawable.minivan),
        Ride("Alice Brown", "2023-09-08", "Times Square to Brooklyn", Res.drawable.suv),
        Ride("Bob White", "2023-09-06", "Queens to Manhattan", Res.drawable.sedan),
        Ride("Charlie Green", "2023-09-04", "Harlem to Bronx", Res.drawable.cabriolet),
    )

    @Composable
    fun UserActivityScreen(rides: List<Ride>) {
        val state = remember { SearchStateModel() }
        val scrollState = rememberScrollState()

        Column(modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(scrollState)) {
            TopBar()
            SearchBar(
                state = state,
                onTextChanged =
                {
                },
            )
            RideList(rides)
        }
    }

    @Composable
    fun TopBar() {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "User Activity",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.padding(top = 5.dp, bottom = 10.dp)
            )
            //Icon(Icons.Default.AccountCircle, contentDescription = "Profile", modifier = Modifier.size(32.dp))
        }
    }

    @Composable
    fun SearchBar(
        state: SearchStateModel,
        onTextChanged: (String) -> Unit
    ) {
        var text by remember { mutableStateOf("") }

        LaunchedEffect(state.query) {
            state.updateQuery(text) // Keep the state updated
        }

        androidx.compose.material3.TextField(
            value = text,
            onValueChange = {
                text = it
                state.updateQuery(it)
                onTextChanged(it)
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(2.dp, Color.LightGray), RoundedCornerShape(10.dp)),
            leadingIcon = {
                androidx.compose.material3.Icon(
                    painter = painterResource(Res.drawable.search),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            placeholder = {
                androidx.compose.material3.Text(
                    text = "Search your Ride...",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                )
            },
            shape = MaterialTheme.shapes.medium,
            colors = androidx.compose.material3.TextFieldDefaults.colors(
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.White
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            )
        )
    }


    @Composable
    fun TabBar() {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Text(
                text = "My Rides",
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier.clickable {})
            // Text(text = "Profile", color = Color.Gray, modifier = Modifier.clickable {})
            // Text(text = "Help", color = Color.Gray, modifier = Modifier.clickable {})
        }
    }

    @Composable
    fun RideList(rides: List<Ride>) {
        Column {
            rides.forEach { ride ->
                RideCard(ride)
            }
        }
    }

    @Composable
    fun RideCard(ride: Ride) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = 4.dp,
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                androidx.compose.material3.Icon(
                    painter = painterResource(ride.imageRes),
                    contentDescription = "Ride Image",
                    modifier = Modifier.size(64.dp),
                    tint = Color(0xFF665FF0)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = ride.name,
                        fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Date: ${ride.date}",
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Route: ${ride.route}",
                        fontSize = 13.sp
                    )
                }
            }
        }
    }

}