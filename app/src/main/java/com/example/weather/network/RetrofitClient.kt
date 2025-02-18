package com.example.weather.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.weather.api.WeatherApi // Импортируйте интерфейс

object RetrofitClient {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    val instance: WeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Указываем базовый URL
            .addConverterFactory(GsonConverterFactory.create()) // Добавляем конвертер для JSON
            .build()
            .create(WeatherApi::class.java) // Создаем экземпляр интерфейса
    }
}