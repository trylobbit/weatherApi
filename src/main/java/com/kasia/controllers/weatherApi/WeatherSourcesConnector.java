package com.kasia.controllers.weatherApi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kasia on 06.04.18.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "weather")
public class WeatherSourcesConnector {
    private String woeidUrl;
    private String resultUrl;

    public String getWoeidUrl() {
        return woeidUrl;
    }

    public void setWoeidUrl(String woeidUrl) {
        this.woeidUrl = woeidUrl;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }
}
