package com.weatherforecast.models.tomorrowio;

import lombok.Data;

@Data
public class Values {
    private String cloudBase;
    private String cloudCeiling;
    private String cloudCover;
    private Double dewPoint;
    private Double freezingRainIntensity;
    private Double humidity;
    private Double precipitationProbability;
    private Double pressureSurfaceLevel;
    private Double rainIntensity;
    private Double sleetIntensity;
    private Double snowIntensity;
    private Double temperature;
    private Double temperatureApparent;
    private Double uvHealthConcern;
    private Double uvIndex;
    private Double visibility;
    private Double weatherCode;
    private Double windDirection;
    private Double windGust;
    private Double windSpeed;

}
