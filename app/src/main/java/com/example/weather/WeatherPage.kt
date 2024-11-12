package com.example.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

// Import the existing WeatherViewModel class here if defined elsewhere
// import com.example.weather.WeatherViewModel

@Composable
fun WeatherPage(viewModel: WeatherViewModel, modifier: Modifier = Modifier) {
    val city = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = city.value,
                onValueChange = { city.value = it },
                label = {
                    Text(text = "Search for any location")
                }
            )
            IconButton(onClick = {
                viewModel.getData(city.value) // Pass the value of the city as a String
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search for any location"
                )
            }
        }
    }
}
