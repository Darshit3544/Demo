package org.example.demoproject.bottomNavigationBar.HomeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.drivein.utils.Constants
import demoproject.composeapp.generated.resources.Res
import demoproject.composeapp.generated.resources.*
import demoproject.composeapp.generated.resources.search
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

class HomeScreen {
    @Composable
    fun HomeScreen() {
        val state = remember { SearchStateModel() }

        // Column Composable,
        Column(
            modifier = Modifier
                .fillMaxSize(),


            ) {
            WelcomeBanner()
            launchingBanner()
            selectCarType(Constants.carTypeList)
            SearchBar(state = state,
                onTextChanged =
                { query ->
                    println("User typed: $query")
                })
        }
    }

    @Composable
    fun SearchBar(state: SearchStateModel, onTextChanged: (String) -> Unit) {
        var text by remember { mutableStateOf("") }

        LaunchedEffect(state.query) {
            state.updateQuery(text) // Keep the state updated
        }

        TextField(
            value = text,
            onValueChange = {
                text = it
                state.updateQuery(it)
                onTextChanged(it)
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(BorderStroke(2.dp, Color.LightGray), RoundedCornerShape(10.dp)),
            leadingIcon = {
                Icon(
                    painter = painterResource(Res.drawable.search),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            placeholder = {
                androidx.compose.material3.Text(
                    text = "Where To?",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                )
            },
            shape = MaterialTheme.shapes.medium,
            colors = TextFieldDefaults.colors(
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
    fun selectCarType(items: List<CarTypeModel>) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items.forEach { item ->
                ScrollingItemView(item)
            }
        }
    }

    @Composable
    fun ScrollingItemView(item: CarTypeModel) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(75.dp)
        ) {
            // Use Image to display the icon, and Text to display the text
            Image(
                painter = painterResource(item.icon), // Convert string ID to resource ID
                contentDescription = item.label,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = item.label)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun WelcomeBanner() {
        TopAppBar(title = {
            Text(
                text = "Welcome Darshit",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.padding(top = 10.dp, start = 10.dp)
            )
        }, actions = {

        })

    }

    @Composable
    fun launchingBanner() {
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
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(
                        text = "Just sit back and relax -",
                        fontSize = 15.sp,
                        color = Color.White
                    )
                }

                //Spacer(modifier = Modifier.height(12.dp))

                Image(
                    painter = painterResource(Res.drawable.banner), // Replace with your image
                    contentDescription = "Navigation Image",
                    modifier = Modifier
                        .height(120.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .weight(0.3f)
                )
            }
        }
    }
}