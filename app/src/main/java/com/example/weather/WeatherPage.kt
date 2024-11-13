package com.example.weather

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import com.example.weather.api.NetworkResponse
import com.example.weather.api.WeatherModel

// Import the existing WeatherViewModel class here if defined elsewhere
// import com.example.weather.WeatherViewModel

@Composable
fun WeatherPage(viewModel: WeatherViewModel, modifier: Modifier = Modifier) {
    val city = remember { mutableStateOf("") }
    val weatherResult = viewModel.weatherResult.observeAsState()

    val keyboardController = LocalSoftwareKeyboardController.current
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
                viewModel.getData(city.value)
                keyboardController?.hide()
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search for any location"
                )
            }
        }
        when (val result = weatherResult.value) {
            is NetworkResponse.Error -> {
                Text(text = result.message)
            }

            NetworkResponse.Loading -> {

                CircularProgressIndicator()
            }

            is NetworkResponse.Success -> {
                WeatherDetails(data = result.data)
            }

            null -> {}
        }
    }
}

@Composable
fun WeatherDetails(data: WeatherModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn, // Correct parameter name
                contentDescription = "Location Icon",
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = data.location.name,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = data.location.country, fontSize = 18.sp, color = Color.Gray)


        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = " ${data.current.temp_c} °C",
            fontSize = 56.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center

        )
        AsyncImage(
            modifier = Modifier.size(160.dp),
            model = "https:${data.current.condition.icon}".replace("64x64", "128x128"),
            contentDescription = "Condition Icon"
        )
        Text(
            text = data.current.condition.text,
            fontSize = 20.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center

        )
        Spacer(modifier = Modifier.height(16.dp))
        Card() {
            Column (
                modifier = Modifier.fillMaxWidth()
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherKeyVal("Humidity",data.current.humidity)
                    WeatherKeyVal("Wind Speed",data.current.wind_kph + " km/h")

                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherKeyVal("uv",data.current.uv)
                    WeatherKeyVal("Precipitation",data.current.precip_mm+ " mm")

                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherKeyVal("Local Time",data.location.localtime.split(" ")[1])
                    WeatherKeyVal("Local Date",data.location.localtime.split(" ")[0])

                }
            }
        }
    }
}
@Composable
fun WeatherKeyVal(key : String , value : String ){
    Column (
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = value, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = key, fontWeight = FontWeight.SemiBold, color = Color.Gray)

    }
}