package com.kasia.controllers.weatherApi;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kasia on 04.04.18.
 */
@Component
public class RestConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();

    }

}
