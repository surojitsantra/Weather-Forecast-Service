package com.weatherforecast.client;

import com.weatherforecast.models.tomorrowio.WeatherClientData;

public interface WeatherClient {
    public WeatherClientData getWeatherInfo(String zipCode);
}
