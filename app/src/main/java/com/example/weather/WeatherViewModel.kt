package com.example.weather

import android.util.Log // Add this import for Log
import androidx.lifecycle.ViewModel

class WeatherViewModel : ViewModel() {
    fun getData(city: String) {
        Log.i("City Name: ", city) // This will log the city name
    }
}
