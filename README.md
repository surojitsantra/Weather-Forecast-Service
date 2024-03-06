# ze-rabbit-consumer

A Weather Forecast Service provides predictive information about current temperature and high/low temperature extended forecast. The service is based on the TomorrowIo API.

## Requirements
TomorowIo API Key - added in properties file

## Features
- Get current temperature
- Get high/low temperature extended forecast
- Get weather forecast for a specific zip code

## Usage
- Get current temperature
```
GET : http://localhost:8080/v1/weather?zipcode=<zipcode>
```
