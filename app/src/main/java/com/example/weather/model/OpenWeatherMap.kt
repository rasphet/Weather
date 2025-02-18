package com.example.weather.model

data class WeatherResponse(
    val name: String, // Название города
    val main: Main,   // Основные данные (температура, влажность)
    val weather: List<Weather> // Список погодных условий
)

data class Main(
    val temp: Double, // Температура
    val humidity: Int  // Влажность
)

data class Weather(
    val description: String, // Описание погоды
    val icon: String         // Иконка
)