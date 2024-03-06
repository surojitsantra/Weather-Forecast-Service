package com.weatherforecast.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfo {
    private double currentTemperature;
    private double highTemperature;
    private double lowTemperature;
}
