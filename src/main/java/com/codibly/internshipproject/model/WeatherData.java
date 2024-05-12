package com.codibly.internshipproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherData {


    @JsonProperty("daily")
    private DailyData daily;

    public DailyData getDaily() {
        return daily;
    }

    public void setDaily(DailyData daily) {
        this.daily = daily;
    }

     public static class DailyData {
        @JsonProperty("time")
        private List<String> date;
        @JsonProperty("temperature_2m_min")
        private List<Double> minTemp;
        @JsonProperty("temperature_2m_max")
        private List<Double> maxTemp;
        @JsonProperty("weather_code")
        private List<Integer> weatherCodes;

        @JsonProperty("sunshine_duration")
        private List<Double> sunSeconds;

        private List<Double> generatedEnergy;
        public List<Integer> getWeatherCodes() {
            return weatherCodes;
        }

        public void setWeatherCodes(List<Integer> weatherCodes) {
            this.weatherCodes = weatherCodes;
        }

         public List<Double> getMinTemp() {
             return minTemp;
         }

         public void setMinTemp(List<Double> minTemp) {
             this.minTemp = minTemp;
         }

         public List<Double> getMaxTemp() {
             return maxTemp;
         }

         public void setMaxTemp(List<Double> maxTemp) {
             this.maxTemp = maxTemp;
         }

         public List<Double> getSunSeconds() {
             return sunSeconds;
         }

         public void setSunSeconds(List<Double> sunSeconds) {
             this.sunSeconds = sunSeconds;
         }

         public List<String> getDate() {
             return date;
         }

         public void setDate(List<String> date) {
             this.date = date;
         }

         public List<Double> getGeneratedEnergy() {
             return generatedEnergy;
         }

         public void setGeneratedEnergy(List<Double> generatedEnergy) {
             this.generatedEnergy = generatedEnergy;
         }
     }
}