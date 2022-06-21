package com.example.xifeng2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.xifeng2.GetContext.MyApplication;
import com.example.xifeng2.R;
import com.example.xifeng2.databinding.HomeinfoLayoutBinding;

import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public class HomeInfo_Adapter{
    private Context context;
    private HomeInfo    homeInfo;
    HomeinfoLayoutBinding binding;

    public HomeInfo_Adapter(Context context, HomeInfo homeInfo) {
        this.context = context;
        this.homeInfo = homeInfo;
    }
    public HomeInfo_Adapter(HomeInfo homeInfo) {
        this.context = MyApplication.getContext();
        this.homeInfo = homeInfo;
    }

    public void bindViewGroup(ViewGroup id) {
        View v=LayoutInflater.from(context).inflate(R.layout.homeinfo_layout,id,true);
        TextView    keyCity=v.findViewById(R.id.key_city);
        TextView    keyAirQuality=v.findViewById(R.id.key_air_quality);
        TextView    keyData=v.findViewById(R.id.key_data);
        TextView    keyDressing=v.findViewById(R.id.key_dressing);
        TextView    keyTemp=v.findViewById(R.id.key_temp);
        TextView    keySkycon=v.findViewById(R.id.key_skycon);
        TextView    keyUltra=v.findViewById(R.id.key_ultra);
        TextView    keyWind=v.findViewById(R.id.key_wind);
        keyCity.setText(homeInfo.getCity());
        keyAirQuality.setText(homeInfo.getAir_quality());
        keyData.setText(homeInfo.getDate());
        keyDressing.setText(homeInfo.getDressing());
        keyTemp.setText(homeInfo.getTemp());
        keySkycon.setText(homeInfo.getSkycon());
        keyUltra.setText(homeInfo.getUltraviolet());
        keyWind.setText(homeInfo.getWind());
    }

}
