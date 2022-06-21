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

    public HomeInfo(){
        shareEdit=new ShareEdit();
        shareEdit.InitShareEdit();

        String  unknown="未知数据";

        temp=shareEdit.GetKeyString(R.string.温度,"温度: "+unknown);
        city=shareEdit.GetKeyString(R.string.城市_区域,"city: "+unknown);
        skycon=shareEdit.GetKeyString(R.string.天气,"skycon: "+unknown);
        date=shareEdit.GetKeyString(R.string.最后更新时间,"date: "+unknown);
        wind=shareEdit.GetKeyString(R.string.风力,"wind: "+unknown);
        ultraviolet=shareEdit.GetKeyString(R.string.紫外线,"紫外线: "+unknown);
        dressing=shareEdit.GetKeyString(R.string.穿衣指数,"Dressing: "+unknown);
        air_quality=shareEdit.GetKeyString(R.string.空气质量,"Air_quality: "+unknown);
    }

    public HomeInfo(realtime info){
        shareEdit=new ShareEdit();
        shareEdit.InitShareEdit();

        city=shareEdit.GetCity(R.string.城市,"")+"-"+shareEdit.GetDistrict(R.string.区域,"");
        skycon=info.getResult().getRealtime().getSkycon();
        temp="温度: "+info.getResult().getRealtime().getTemperature()+"℃";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        java.util.Date  curDate =new Date(System.currentTimeMillis());
        date=format.format(curDate);
        wind="风速: "+info.getResult().getRealtime().getWind().getSpeed()+"km/h";
        ultraviolet="紫外线程度-"+info.getResult().getRealtime().getLife_index().getUltraviolet().getDesc();
        dressing="穿衣指数-"+info.getResult().getRealtime().getLife_index().getComfort().getDesc();
        air_quality="空气质量-"+info.getResult().getRealtime().getAir_quality().getDescription().getUsa();
        skycon="天气-"+info.getResult().getRealtime().getSkycon().toLowerCase();

        //向sharedperferences写入数据
        shareEdit.SetKeyString(R.string.风力,wind);
        shareEdit.SetKeyString(R.string.紫外线,ultraviolet);
        shareEdit.SetKeyString(R.string.穿衣指数,dressing);
        shareEdit.SetKeyString(R.string.空气质量,air_quality);
        shareEdit.SetKeyString(R.string.天气,skycon);
        shareEdit.SetKeyString(R.string.最后更新时间,date);
        shareEdit.SetKeyString(R.string.温度,temp);
        shareEdit.SetKeyString(R.string.城市_区域,city);
        shareEdit.Commit();
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

    public ShareEdit getShareEdit() {
        return shareEdit;
    }
}





enum WeatherPhenomenon{
    CLEAR_DAY,CLEAR_NIGHT,PARTLY_CLOUDY_DAY,PARTLY_CLOUDY_NIGHT,CLOUDY,
    LIGHT_HAZE,MODERATE_HAZE,HEAVY_HAZE,LIGHT_RAIN,MODERATE_RAIN,HEAVY_RAIN,
    STORM_RAIN,FOG,LIGHT_SNOW,MODERATE_SNOW,HEAVY_SNOW,STORM_SNOW,DUST,SAND,WIND
}