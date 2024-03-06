package com.weatherforecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherForecastServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastServiceApplication.class, args);
		System.out.println("WeatherForecastServiceApplication is running");
	}

}
