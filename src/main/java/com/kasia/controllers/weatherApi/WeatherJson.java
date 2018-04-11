package com.kasia.controllers.weatherApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kasia on 05.04.18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherJson {

    @JsonProperty("consolidated_weather")
    public Weather[] consolidatedWeather;


    public List<Weather> getConsolidatedWeather(Integer amountOfDays) {


        List<Weather> listOfWeather = new ArrayList<>();

        listOfWeather.addAll(Arrays.asList(consolidatedWeather).subList(0, amountOfDays));

        return listOfWeather;
    }

    public void setConsolidatedWeather(Weather[] consolidatedWeather) {
        this.consolidatedWeather = consolidatedWeather;
    }


}
