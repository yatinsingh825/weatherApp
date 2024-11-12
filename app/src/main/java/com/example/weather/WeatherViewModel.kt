package com.example.weather

import android.util.Log // Add this import for Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.api.Constant
import com.example.weather.api.NetworkResponse
import com.example.weather.api.RetroInstance
import com.example.weather.api.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val weatherApi = RetroInstance.weatherApi
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult: LiveData<NetworkResponse<WeatherModel>> = _weatherResult

    fun getData(city: String) {
        viewModelScope.launch {
            try {
                _weatherResult.value = NetworkResponse.Loading
                val response = weatherApi.getWeather(Constant.apiKey, city)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _weatherResult.value = NetworkResponse.Success(it)
                    } ?: run {
                        _weatherResult.value = NetworkResponse.Error("No data available")
                    }
                } else {
                    _weatherResult.value = NetworkResponse.Error("Error: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("WeatherViewModel", "Exception: ${e.message}")
                _weatherResult.value = NetworkResponse.Error("Exception: ${e.message}")
            }
        }
    }
}
