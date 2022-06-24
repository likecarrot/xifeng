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

    private int    icon;

    private int[] iconSet= new int[]{
            R.drawable.qing1,R.drawable.qing1,R.drawable.duoyun1,R.drawable.duoyun2,
            R.drawable.yin,R.drawable.wumai,R.drawable.wumai,R.drawable.wumai,
            R.drawable.yu1,R.drawable.yu2,R.drawable.yu3,R.drawable.yu3,
            R.drawable.wu,R.drawable.xue1,R.drawable.wu,R.drawable.xue2,R.drawable.wu,R.drawable.xue3,R.drawable.wu,R.drawable.xue,
            R.drawable.fuchen,R.drawable.fuchen,R.drawable.dafeng
    };
    private String[] phonameno=new String[]{
            "CLEAR_DAY","CLEAR_NIGHT","PARTLY_CLOUDY_DAY"
            ,"PARTLY_CLOUDY_NIGHT","CLOUDY","LIGHT_HAZE"
            ,"MODERATE_HAZE","HEAVY_HAZE","LIGHT_RAIN"
            ,"MODERATE_RAIN","HEAVY_RAIN","STORM_RAIN"
            ,"FOG","LIGHT_SNOW","MODERATE_SNOW","HEAVY_SNOW"
            ,"STORM_SNOW","DUST","SAND","WIND"
    };
    private String[]    phonamenoCN=new String[]{
          "晴（白天）","晴（夜间）","多云（白天）","多云（夜间）"
            ,"阴","轻度雾霾","中度雾霾","重度雾霾"
            ,"小雨","中雨","大雨","暴雨"
            ,"雾","小雪","中雪","大雪","暴雪"
            ,"浮尘","沙尘","大风"
    };

    private ShareEdit   shareEdit=new ShareEdit();


    public HomeInfo(){
        String  unknown="未知数据";
        temp=shareEdit.GetKeyString(R.string.温度,"温度: "+unknown);
        city=shareEdit.GetKeyString(R.string.城市_区域,"NULL");

        skycon=shareEdit.GetKeyString(R.string.天气,"skycon: "+unknown);
        date=shareEdit.GetKeyString(R.string.最后更新时间,"date: "+unknown);
        wind=shareEdit.GetKeyString(R.string.风力,"wind: "+unknown);
        ultraviolet=shareEdit.GetKeyString(R.string.紫外线,"紫外线: "+unknown);
        dressing=shareEdit.GetKeyString(R.string.穿衣指数,"Dressing: "+unknown);
        air_quality=shareEdit.GetKeyString(R.string.空气质量,"Air_quality: "+unknown);
        icon=shareEdit.GetKeyInt(R.string.天气状况,0);
    }

    public HomeInfo(realtime info){
        city=shareEdit.GetCity()+"-"+shareEdit.GetDistrict();
        skycon=info.getResult().getRealtime().getSkycon();
        temp="实时温度: "+info.getResult().getRealtime().getTemperature()+"℃";
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        java.util.Date  curDate =new Date(System.currentTimeMillis());
        date="最后更新时间:"+format.format(curDate);
        wind="风速: "+info.getResult().getRealtime().getWind().getSpeed()+"km/h";
        ultraviolet="紫外线程度:"+info.getResult().getRealtime().getLife_index().getUltraviolet().getDesc();
        dressing="穿衣指数:"+info.getResult().getRealtime().getLife_index().getComfort().getDesc();
        air_quality="空气质量:"+info.getResult().getRealtime().getAir_quality().getDescription().getUsa();
        icon=getIconResource(info.getResult().getRealtime().getSkycon().toUpperCase());
        skycon="天气状况:"+getSkyconCN(info.getResult().getRealtime().getSkycon().toUpperCase());

        //向sharedperferences写入数据
        shareEdit.SetKeyString(R.string.风力,wind);
        shareEdit.SetKeyString(R.string.紫外线,ultraviolet);
        shareEdit.SetKeyString(R.string.穿衣指数,dressing);
        shareEdit.SetKeyString(R.string.空气质量,air_quality);
        shareEdit.SetKeyString(R.string.天气,skycon);
        shareEdit.SetKeyString(R.string.最后更新时间,date);
        shareEdit.SetKeyString(R.string.温度,temp);
        shareEdit.SetKeyString(R.string.城市_区域,city);
        shareEdit.SetKeyInt(R.string.天气状况,icon);
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

    public int  getIcon(){
        return icon;
    }

    private int getIconResource(String info){
        for (int i=0;i<phonameno.length;i++){
            if (info==phonameno[i]){
                return iconSet[i];
            }
        }
        return iconSet[0];
    }
    private String getSkyconCN(String info){
        for(int i=0;i<phonameno.length;i++){
            if(info.equals(phonameno[i])){
                return phonamenoCN[i];
            }
        }
        return "未知";
    }

}

