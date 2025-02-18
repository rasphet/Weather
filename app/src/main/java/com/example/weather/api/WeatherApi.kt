package com.example.weather.api

import com.example.weather.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    fun getCurrentWeather(
        @Query("q") city: String, // Город
        @Query("units") units: String = "metric", // Единицы измерения (метрические)
        @Query("appid") apiKey: String // API ключ
    ): Call<WeatherResponse> // Используем WeatherResponse для парсинга
}