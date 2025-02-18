package com.example.weather

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {

    // Используем ViewBinding
    private lateinit var binding: ActivityMainBinding

    // Используем by viewModels() для получения ViewModel
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Инициализация ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Обработка нажатия на кнопку
        binding.getWeatherButton.setOnClickListener {
            val city = binding.cityInput.text.toString()
            val apiKey = "95e89edcc92242a2d74f5d7fea2142ea" // Замените на ваш ключ
            viewModel.loadWeather(city, apiKey)
        }

        // Наблюдение за LiveData
        viewModel.weatherData.observe(this) { weather ->
            binding.weatherInfo.text = """
                Город: ${weather.name}
                Температура: ${weather.main.temp}°C
                Влажность: ${weather.main.humidity}%
                Погода: ${weather.weather[0].description}
            """.trimIndent()
        }
    }
}