package com.weatherforecast.controllers;

import com.weatherforecast.models.WeatherInfo;
import com.weatherforecast.services.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Slf4j
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<WeatherInfo> getWeather(@RequestParam String zipcode) {
        log.info("Getting weather info for zipcode: {}", zipcode);
        WeatherInfo weatherInfo = weatherService.getWeatherInfo(zipcode);
        log.info("Weather info for zipcode: {} is: {}", zipcode, weatherInfo);
        return ResponseEntity.ok(weatherInfo);
    }
}
