package com.codibly.internshipproject.controller;

import com.codibly.internshipproject.model.WeatherData;
import com.codibly.internshipproject.service.WeatherService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
public class WeatherController {
    private final WeatherService weatherService;


    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherData getWeather(
            @RequestParam @Min(value = -90, message = "Latitude must be at least -90.") @Max(value = 90, message = "Latitude must be no more than 90.") double latitude,
            @RequestParam @Min(value = -180, message = "Longitude must be at least -180.") @Max(value = 180, message = "Longitude must be no more than 180.") double longitude
    ) {
        return weatherService.getProcessedWeatherData(latitude, longitude);
    }
}
