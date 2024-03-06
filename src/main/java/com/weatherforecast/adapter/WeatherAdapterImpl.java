package com.weatherforecast.adapter;

import com.weatherforecast.client.WeatherClient;
import com.weatherforecast.models.WeatherInfo;
import com.weatherforecast.models.tomorrowio.WeatherClientData;
import org.springframework.stereotype.Service;

@Service
public class WeatherAdapterImpl implements WeatherAdapter {

    private final WeatherClient weatherClient;

    public WeatherAdapterImpl(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @Override
    public WeatherInfo getWeatherInfo(String zipcode) {
        WeatherClientData weatherClientData = this.weatherClient.getWeatherInfo(zipcode);

        //convert the response from the client to the WeatherInfo object
        WeatherInfo weather = new WeatherInfo();
        weather.setCurrentTemperature(weatherClientData.getData().getValues().getTemperature());
        weather.setHighTemperature(weatherClientData.getData().getValues().getTemperatureApparent());
        weather.setLowTemperature(weatherClientData.getData().getValues().getDewPoint());

        return weather;
    }
}
