package com.kasia.controllers.weatherApi;


import org.springframework.cache.annotation.Cacheable;

/**
 * Created by kasia on 04.04.18.
 */
public class CityDetails {

    private Integer woeid;
    private String title;


    public Integer getWoeid() {
        return woeid;
    }

    public void setWoeid(Integer woeid) {
        this.woeid = woeid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CityDetails{" +
                "woeid=" + woeid +
                ", title='" + title + '\'' +
                '}';
    }
}
