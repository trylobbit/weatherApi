package com.kasia.controllers.otherexercises;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


public class HttpClientApache {

    public void sendGet() throws Exception {

        HttpClient httpClient = HttpClientBuilder.create().build();


        //Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
        //Choice depends on type of method you will be invoking.
        HttpGet getRequest = new HttpGet("https://www.metaweather.com/api/location/44418/");

        //Set the API media type in http accept header
        getRequest.addHeader("accept", "application/json");

        //Send the request; It will immediately return the response in HttpResponse object
        HttpResponse response = httpClient.execute(getRequest);

        String responseAsString = EntityUtils.toString(response.getEntity());

        System.out.println(responseAsString);

    }
}





