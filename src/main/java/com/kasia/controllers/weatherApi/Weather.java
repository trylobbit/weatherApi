package com.kasia.controllers.weatherApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by kasia on 04.04.18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private Date applicable_date;
    private BigInteger id;
    private double min_temp;
    private double max_temp;
    private float air_pressure;

    public String getApplicable_date() {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(applicable_date);
        return date;
    }

    public void setAplicable_date(Date aplicable_date) {
        this.applicable_date = aplicable_date;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public double getMin_temp() {
        return Math.round(min_temp);
    }

    public void setMin_temp(double min_temp) {
        this.min_temp = min_temp;
    }

    public double getMax_temp() {
        return Math.round(max_temp);
    }

    public void setMax_temp(double max_temp) {
        this.max_temp = max_temp;
    }

    public float getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(float air_pressure) {
        this.air_pressure = air_pressure;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "applicable_date='" + applicable_date + '\'' +
                ", id=" + id +
                ", min_temp=" + min_temp +
                ", max_temp=" + max_temp +
                ", air_pressure=" + air_pressure +
                '}';
    }
}
