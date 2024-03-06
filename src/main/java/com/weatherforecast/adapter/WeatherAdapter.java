package com.weatherforecast.adapter;

import com.weatherforecast.models.WeatherInfo;

public interface WeatherAdapter {
    public WeatherInfo getWeatherInfo(String zipcode);
}
