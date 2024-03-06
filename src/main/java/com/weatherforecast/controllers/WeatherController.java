package com.weatherforecast.controllers;

import com.weatherforecast.models.WeatherInfo;
import com.weatherforecast.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<WeatherInfo> getWeather(@RequestParam String zipcode) {
        WeatherInfo weatherInfo = weatherService.getWeatherInfo(zipcode);
        return ResponseEntity.ok(weatherInfo);
    }
}
