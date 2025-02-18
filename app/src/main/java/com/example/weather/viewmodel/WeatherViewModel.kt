package com.example.weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.model.WeatherResponse
import com.example.weather.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherViewModel : ViewModel() {
    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse> get() = _weatherData

    fun loadWeather(city: String, apiKey: String) {
        RetrofitClient.instance.getCurrentWeather(city, apiKey = apiKey).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    _weatherData.value = response.body() // Парсинг JSON-ответа
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                // Обработка ошибок
            }
        })
    }
}