package com.weatherforecast.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
public class WeatherForecastGlobalExceptionHandler {
    @ExceptionHandler(WeatherServiceException.class)
    @ResponseBody
    public ResponseEntity<String> handleWeatherServiceException(WeatherServiceException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation error: " + ex.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseEntity<String> handleBindException(BindException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bind error: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred" + ex.getMessage());
    }
}
