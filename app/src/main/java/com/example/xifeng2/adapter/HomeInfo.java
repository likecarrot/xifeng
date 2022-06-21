package com.example.xifeng2.adapter;

import android.app.Activity;
import android.content.Context;

import com.example.xifeng2.GetContext.MyApplication;
import com.example.xifeng2.R;
import com.example.xifeng2.RetClass.realtime;
import com.example.xifeng2.ShareEdit.ShareEdit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import androidx.core.app.ActivityCompat;

public class HomeInfo {
    private String   temp;       //气温 25.3c --
    private String  city;       //城市名称 周口:郸城    --
    private String skycon;      //天气情况:晴朗&
    private String  date;       //2022-06-21    --
    private String  wind;       //风力4-5级    --
    private String ultraviolet;    //紫外线    --
    private String dressing;       //穿衣指数 0~8  热~寒冷
    private String  air_quality;    //空气质量

    private ShareEdit   shareEdit;

//    private String comfort;        //舒适度指数0~13 闷热~舒适~干冷
//    private String coldRisk;       //感冒指数
//    private String carWashing;     //洗车指数
// private String  temp_region;    //温度区间 28°C~32℃
//    private HomeInfo_DailyWeather   todayto1;
//    private HomeInfo_DailyWeather   todayto2;
//    private HomeInfo_DailyWeather   todayto3;


    public HomeInfo(realtime info){
        temp=info.getResult().getRealtime().getTemperature()+"℃";
        shareEdit=new ShareEdit();
        shareEdit.InitShareEdit();
        city=shareEdit.GetCity(R.string.城市,"")+"-"+shareEdit.GetDistrict(R.string.区域,"");
        skycon=info.getResult().getRealtime().getSkycon();

        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        java.util.Date  curDate =new Date(System.currentTimeMillis());
        date=format.format(curDate);

        wind=info.getResult().getRealtime().getWind()+"级";

        ultraviolet="紫外线程度-"+info.getResult().getRealtime().getLife_index().getUltraviolet().getDesc();
        dressing="穿衣指数-"+info.getResult().getRealtime().getLife_index().getComfort().getDesc();
        air_quality="空气质量-"+info.getResult().getRealtime().getAir_quality().getDescription().getUsa();
        skycon="天气-"+info.getResult().getRealtime().getSkycon().toLowerCase();
    }

    public String getTemp() {
        return temp;
    }

    public String getCity() {
        return city;
    }

    public String getSkycon() {
        return skycon;
    }

    public String getDate() {
        return date;
    }

    public String getWind() {
        return wind;
    }

    public String getUltraviolet() {
        return ultraviolet;
    }

    public String getDressing() {
        return dressing;
    }

    public String getAir_quality() {
        return air_quality;
    }
}











enum WeatherPhenomenon{
    CLEAR_DAY,CLEAR_NIGHT,PARTLY_CLOUDY_DAY,PARTLY_CLOUDY_NIGHT,CLOUDY,
    LIGHT_HAZE,MODERATE_HAZE,HEAVY_HAZE,LIGHT_RAIN,MODERATE_RAIN,HEAVY_RAIN,
    STORM_RAIN,FOG,LIGHT_SNOW,MODERATE_SNOW,HEAVY_SNOW,STORM_SNOW,DUST,SAND,WIND
}