package com.weatherforecast.models.tomorrowio;

import lombok.Data;

@Data
public class Location {
    private Double lat;
    private Double lon;
    private String name;
    private String type;
}
