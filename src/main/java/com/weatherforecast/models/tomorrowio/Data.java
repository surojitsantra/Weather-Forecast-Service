package com.weatherforecast.models.tomorrowio;

import java.time.LocalDateTime;

@lombok.Data
public class Data {
    private LocalDateTime time;
    private Values values;
}
