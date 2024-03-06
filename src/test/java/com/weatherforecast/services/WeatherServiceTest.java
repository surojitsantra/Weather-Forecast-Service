package com.weatherforecast.services;

import com.weatherforecast.adapter.WeatherAdapter;
import com.weatherforecast.models.WeatherInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherServiceTest {
    @InjectMocks
    private WeatherService weatherService;
    @Mock
    private WeatherAdapter weatherAdapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetWeatherInfo() {
        // Arrange
        String zipcode = "12345";
        WeatherInfo WeatherInfo = new WeatherInfo(10, 20, 5);
        when(weatherAdapter.getWeatherInfo(zipcode)).thenReturn(WeatherInfo);
        // Act
        WeatherInfo weatherInfo = weatherService.getWeatherInfo(zipcode);
        // Assert
        assertEquals(weatherInfo.getCurrentTemperature(), weatherInfo.getCurrentTemperature());
        assertEquals(weatherInfo.getLowTemperature(), weatherInfo.getLowTemperature());
        assertEquals(weatherInfo.getHighTemperature(), weatherInfo.getHighTemperature());
    }

}
