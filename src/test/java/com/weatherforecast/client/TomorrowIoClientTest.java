package com.weatherforecast.client;

import com.weatherforecast.exceptions.WeatherServiceException;
import com.weatherforecast.models.tomorrowio.WeatherClientData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class TomorrowIoClientTest {
    @InjectMocks
    private TomorrowIoClient tomorrowIoClient;
    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetWeatherInfo() {
        // Arrange
        String zipCode = "12345";
//        when(baseUrl + endpoint + "?location=" + zipCode + "&apikey=" + apiKey).thenReturn("http://localhost:8080/weather?location=12345&apikey=12345");
        ResponseEntity<WeatherClientData> response = new ResponseEntity<>(new WeatherClientData(), null, 200);
        when(restTemplate.getForEntity(anyString(), eq(WeatherClientData.class))).thenReturn(response);

        // Act
        WeatherClientData weatherInfo = tomorrowIoClient.getWeatherInfo(zipCode);

        // Assert
        assertNotNull(weatherInfo);
    }

    @Test
    public void testGetWeatherInfo_gotErrorStatusCode() {
        // Arrange
        String zipCode = "12345";
//        when(baseUrl + endpoint + "?location=" + zipCode + "&apikey=" + apiKey).thenReturn("http://localhost:8080/weather?location=12345&apikey=12345");
        ResponseEntity<WeatherClientData> response = new ResponseEntity<>(new WeatherClientData(), null, 500);
        when(restTemplate.getForEntity(anyString(), eq(WeatherClientData.class))).thenReturn(response);

        // Act
        assertThrows(WeatherServiceException.class, () -> {
            tomorrowIoClient.getWeatherInfo(zipCode);
        });
    }

}
