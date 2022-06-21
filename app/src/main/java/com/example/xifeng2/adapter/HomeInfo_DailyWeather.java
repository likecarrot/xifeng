package com.example.xifeng2.adapter;

public class HomeInfo_DailyWeather {
    private String  weekday;
    private WeatherPhenomenon    skycon;
    private String  temp_region;

    HomeInfo_DailyWeather(String    weekday,WeatherPhenomenon skycon,String temp_region){
        this.skycon=skycon;
        this.temp_region=temp_region;
        this.weekday=weekday;
    }
}
