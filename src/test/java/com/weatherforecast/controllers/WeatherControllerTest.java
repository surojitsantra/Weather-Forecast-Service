package com.weatherforecast.controllers;

import com.weatherforecast.exceptions.WeatherServiceException;
import com.weatherforecast.models.WeatherInfo;
import com.weatherforecast.services.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class WeatherControllerTest {
    @InjectMocks
    private WeatherController weatherController;
    @Mock
    private WeatherService weatherService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetWeather() {
        // Arrange
        String zipcode = "12345";
        WeatherInfo weatherInfo = new WeatherInfo(12, 20, 8);
        when(weatherService.getWeatherInfo(anyString())).thenReturn(weatherInfo);

        // Act
        ResponseEntity<WeatherInfo> weather = weatherController.getWeather(zipcode);

        // Assert
        assertTrue(weather.getStatusCode().is2xxSuccessful());
        assertEquals(weatherInfo.getCurrentTemperature(), weather.getBody().getCurrentTemperature());
        assertEquals(weatherInfo.getLowTemperature(), weather.getBody().getLowTemperature());
        assertEquals(weatherInfo.getHighTemperature(), weather.getBody().getHighTemperature());
    }

    @Test
    public void testGetWeather_throwsException() {
        // Arrange
        String zipcode = "12345";
        WeatherInfo weatherInfo = new WeatherInfo(12, 20, 8);
        when(weatherService.getWeatherInfo(anyString())).thenThrow(new WeatherServiceException("Error"));

        // Act
        assertThrows(WeatherServiceException.class, () -> {
            weatherController.getWeather(zipcode);
        });

    }


}
