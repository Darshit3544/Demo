package org.example.demoproject.UI

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.example.demoproject.utils.Country
import org.example.demoproject.utils.countryList

@Composable
fun CountryCodePicker(
    selectedCountry: Country,
    onCountrySelected: (Country) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    Column {
        // Button to open picker
        Button(
            onClick = { showDialog = true },
            colors = ButtonColors(
                contentColor = Color.White,
                containerColor = Color(0xFF665FF0),
                disabledContentColor = Color(0xFF665FF0),
                disabledContainerColor = Color(0xFF665FF0)
            )
        ) {
            Text("${selectedCountry.flag} ${selectedCountry.dialCode}")
        }

        // Country Picker Dialog
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Select Country") },
                text = {
                    LazyColumn {
                        items(countryList) { country ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        onCountrySelected(country)
                                        showDialog = false
                                    }
                                    .padding(8.dp)
                            ) {
                                Text(text = "${country.flag} ${country.name} (${country.dialCode})")
                            }
                        }
                    }
                },
                confirmButton = {}
            )
        }
    }
}

@Composable
fun PhoneNumberInput() {
    var selectedCountry by remember { mutableStateOf(countryList[0]) }
    var phoneNumber by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CountryCodePicker(selectedCountry) {
            selectedCountry = it
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone Number") },
            leadingIcon = { Text("${selectedCountry.dialCode}") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
    }
}
