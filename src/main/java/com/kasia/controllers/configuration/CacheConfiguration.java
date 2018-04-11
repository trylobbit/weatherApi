package com.kasia.controllers.configuration;

import com.google.common.cache.CacheBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by kasia on 11.04.18.
 */

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "cache")
public class CacheConfiguration {

    private int expiringTime;
    private int maxSize;

    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager;
        cacheManager = new GuavaCacheManager("woeid");

        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
                .maximumSize(maxSize)
                .expireAfterWrite(expiringTime, TimeUnit.MINUTES);
        cacheManager.setCacheBuilder(cacheBuilder);
        return cacheManager;
    }

}
