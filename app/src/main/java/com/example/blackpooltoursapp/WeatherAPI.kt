package com.example.blackpooltoursapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL

object WeatherAPI {
    private const val API_KEY = "095f21213142d1434ba8916a79917794"
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/weather"

    suspend fun getWeather(city: String): String {
        return withContext(Dispatchers.IO) {
            try {
                val urlString = "$BASE_URL?q=$city&appid=$API_KEY&units=metric"
                val response = URL(urlString).readText()  // simple network call
                val jsonObject = JSONObject(response)
                val temp = jsonObject.getJSONObject("main").getDouble("temp")
                "$temp°C"
            } catch (e: Exception) {
                "Weather unavailable"
            }
        }
    }
}