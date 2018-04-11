package com.kasia.controllers.controllers;

import com.kasia.controllers.weatherApi.City;
import com.kasia.controllers.weatherApi.Weather;
import com.kasia.controllers.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WeatherViewController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherViewController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/home")
    public String formView(Model model) {
        model.addAttribute("city", new City());
        return "home";
    }

    @PostMapping("/home")
    public String submit(@RequestParam String title, @RequestParam Integer amountOfDays, Model model) throws Exception {

        List<Weather> listWeather = weatherService.provideWeather(title, amountOfDays);
        model.addAttribute("listWeather", listWeather);
        return "weather";
    }

}