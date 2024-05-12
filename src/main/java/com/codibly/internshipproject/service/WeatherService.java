package com.codibly.internshipproject.service;

import com.codibly.internshipproject.client.WeatherClient;
import com.codibly.internshipproject.model.WeatherData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {
    private final WeatherClient weatherClient;

    private static final double PANEL_POWER_KW = 2.5;
    private static final double PANEL_EFFICIENCY = 0.2;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }
    public WeatherData getProcessedWeatherData(double latitude, double longitude) {

        WeatherData data = weatherClient.getWeatherData(latitude, longitude);
        if (data != null) {
            List<Double> generatedEnergy = data.getDaily().getSunSeconds().stream()
                    .map(this::calculateGeneratedEnergy)
                    .map(energy -> Math.round(energy * 100.0) / 100.0)
                    .collect(Collectors.toList());
            data.getDaily().setGeneratedEnergy(generatedEnergy);
        }
        return data;
    }

    private double calculateGeneratedEnergy(double sunSeconds) {
        double sunHours = sunSeconds / 3600;
        return PANEL_POWER_KW * sunHours * PANEL_EFFICIENCY;    }


}
