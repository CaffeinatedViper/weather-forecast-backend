package com.codibly.internshipproject.client;

import com.codibly.internshipproject.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
public class WeatherClient {
    private final RestTemplate restTemplate;

    @Value("${weather.api.url}")
    private String apiUrl;

    public WeatherClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherData(double latitude, double longitude) {
        String url = String.format(
                Locale.US, apiUrl,latitude, longitude
        );
        try {
            return restTemplate.getForObject(url, WeatherData.class);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new RuntimeException("Invalid request: " + e.getMessage());
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException("Data not found: " + e.getMessage());
        } catch (HttpServerErrorException e) {
            throw new RuntimeException("Server error: " + e.getStatusCode() + " " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Unknown error occurred: " + e.getMessage());
        }

    }
}
