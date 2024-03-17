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
        WeatherInfo mockedWeatherInfo = new WeatherInfo(10, 20, 5);
        when(weatherAdapter.getWeatherInfo(zipcode)).thenReturn(mockedWeatherInfo);

        // Act
        WeatherInfo weatherInfo = weatherService.getWeatherInfo(zipcode);

        // Assert
        assertEquals(mockedWeatherInfo.getCurrentTemperature(), weatherInfo.getCurrentTemperature());
        assertEquals(mockedWeatherInfo.getLowTemperature(), weatherInfo.getLowTemperature());
        assertEquals(mockedWeatherInfo.getHighTemperature(), weatherInfo.getHighTemperature());
    }

}
