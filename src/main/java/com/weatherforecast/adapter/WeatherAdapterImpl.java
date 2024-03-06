package com.weatherforecast.adapter;

import com.weatherforecast.client.WeatherClient;
import com.weatherforecast.models.WeatherInfo;
import com.weatherforecast.models.tomorrowio.WeatherClientData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeatherAdapterImpl implements WeatherAdapter {

    private final WeatherClient weatherClient;

    public WeatherAdapterImpl(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @Override
    public WeatherInfo getWeatherInfo(String zipcode) {
        WeatherClientData weatherClientData = this.weatherClient.getWeatherInfo(zipcode);
        log.info("Weather data from client: {}", weatherClientData);

        return weatherInfoMapper(weatherClientData);
    }

    private WeatherInfo weatherInfoMapper(WeatherClientData weatherClientData) {
        //convert the response from the client to the WeatherInfo object
        WeatherInfo weather = new WeatherInfo();
        if(weatherClientData == null || weatherClientData.getData() == null || weatherClientData.getData().getValues() == null) {
            return weather;
        }
        weather.setCurrentTemperature(weatherClientData.getData().getValues().getTemperature());
        weather.setHighTemperature(weatherClientData.getData().getValues().getTemperatureApparent());
        weather.setLowTemperature(weatherClientData.getData().getValues().getDewPoint());
        return weather;
    }
}
