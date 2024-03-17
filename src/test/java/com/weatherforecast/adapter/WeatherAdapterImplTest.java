package com.weatherforecast.adapter;

import com.weatherforecast.client.WeatherClient;
import com.weatherforecast.models.WeatherInfo;
import com.weatherforecast.models.tomorrowio.Data;
import com.weatherforecast.models.tomorrowio.Values;
import com.weatherforecast.models.tomorrowio.WeatherClientData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherAdapterImplTest {
    @InjectMocks
    private WeatherAdapterImpl weatherAdapterImpl;
    @Mock
    private WeatherClient weatherClient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetWeatherInfo() {
        // Arrange
        String zipcode = "12345";
        WeatherClientData weatherClientData = new WeatherClientData();
        weatherClientData.setData(new Data());
        weatherClientData.getData().setValues(new Values());
        weatherClientData.getData().getValues().setTemperature(10D);
        weatherClientData.getData().getValues().setTemperatureApparent(20D);
        weatherClientData.getData().getValues().setDewPoint(5D);
        when(weatherClient.getWeatherInfo(zipcode)).thenReturn(weatherClientData);

        // Act
        WeatherInfo weatherInfo = weatherAdapterImpl.getWeatherInfo(zipcode);

        // Assert
        assertEquals(weatherClientData.getData().getValues().getTemperature(), weatherInfo.getCurrentTemperature());
        assertEquals(weatherClientData.getData().getValues().getTemperatureApparent(), weatherInfo.getHighTemperature());
        assertEquals(weatherClientData.getData().getValues().getDewPoint(), weatherInfo.getLowTemperature());
    }
}
