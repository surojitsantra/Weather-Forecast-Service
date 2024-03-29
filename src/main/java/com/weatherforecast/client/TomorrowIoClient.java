package com.weatherforecast.client;

import com.weatherforecast.exceptions.WeatherServiceException;
import com.weatherforecast.models.tomorrowio.WeatherClientData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class TomorrowIoClient implements WeatherClient {
    private final String baseUrl;
    private final String endpoint;
    private final String apiKey;
    private final RestTemplate restTemplate;

    public TomorrowIoClient(@Value("${tomorrowIo.baseUrl}") String baseUrl, @Value("${tomorrowIo.endpoint}") String endpoint, @Value("${tomorrowIo.apiKey}") String apiKey, RestTemplate restTemplate) {
        this.baseUrl = baseUrl;
        this.endpoint = endpoint;
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherClientData getWeatherInfo(String zipCode) {
        String url = buildUrl(zipCode);
        log.info("Getting weather data from Tomorrow.io for zipcode: {}", zipCode);
        log.info("URL: {}", url);

        ResponseEntity<WeatherClientData> response = restTemplate.getForEntity(url, WeatherClientData.class);
        if (response.getStatusCode().isError()) {
            log.error("Error getting weather data from Tomorrow.io");
            throw new WeatherServiceException("Error getting weather data from Tomorrow.io");
        }
        return response.getBody();
    }

    private String buildUrl(String zipcode) {
        return baseUrl + endpoint + "?location=" + zipcode + "&apikey=" + apiKey;
    }
}
