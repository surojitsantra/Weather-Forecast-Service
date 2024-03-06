package com.weatherforecast.services;

import com.weatherforecast.adapter.WeatherAdapter;
import com.weatherforecast.models.WeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherAdapter weatherAdapter;

    @Autowired
    public WeatherService(WeatherAdapter weatherAdapter) {
        this.weatherAdapter = weatherAdapter;
    }
    @Cacheable(value = "weatherCache", key = "#zipcode")
    public WeatherInfo getWeatherInfo(String zipcode) {
        return weatherAdapter.getWeatherInfo(zipcode);
    }
}
