package com.kasia.controllers.services;

import com.google.gson.Gson;
import com.kasia.controllers.weatherApi.CityDetails;
import com.kasia.controllers.weatherApi.WeatherJson;
import com.kasia.controllers.weatherApi.WeatherSourcesConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kasia on 04.04.18.
 */

@Service
public class WeatherApiCommunicator {

    public static final Gson GSON = new Gson();

    @Autowired
    private WeatherSourcesConnector weatherSourcesConnector;

    @Autowired
    private RestTemplate restTemplate;

    @Cacheable(value = "woeid", key ="#query")
    public Integer getWoeid(String query) throws Exception {

        String url = weatherSourcesConnector.getWoeidUrl() + query;
        String response = restTemplate.getForObject(url, String.class);

        return extractWoeidFromResponse(response);
    }

    public WeatherJson getAllWeatherForCity(Integer woeid) {

        String url = weatherSourcesConnector.getResultUrl() + woeid;

        return restTemplate.getForObject(url, WeatherJson.class);
    }


    private Integer extractWoeidFromResponse(String cityJson) {

        CityDetails[] cityDetails = GSON.fromJson(cityJson, CityDetails[].class);

        return (cityDetails.length > 0) ? cityDetails[0].getWoeid() : 0;

    }

}
