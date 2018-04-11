package com.kasia.controllers.services;

import com.kasia.controllers.weatherApi.Weather;
import com.kasia.controllers.weatherApi.WeatherJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WeatherService {

    private final WeatherApiCommunicator weatherApiCommunicator;

    @Autowired
    public WeatherService(WeatherApiCommunicator weatherApiCommunicator) {
        this.weatherApiCommunicator = weatherApiCommunicator;
    }

    public List<Weather> provideWeather(String city, Integer days) throws Exception {


        Integer woeid = weatherApiCommunicator.getWoeid(city);

        WeatherJson weatherJson = weatherApiCommunicator.getAllWeatherForCity(woeid);

        return weatherJson.getConsolidatedWeather(days);
    }

}
