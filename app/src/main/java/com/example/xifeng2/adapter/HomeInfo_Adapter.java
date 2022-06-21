package com.example.xifeng2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

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

    public View getItem(ViewGroup id) {
        binding=DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.homeinfo_layout,id,true);
        binding.keyCity.setText(homeInfo.getCity());
        binding.keyAirQuality.setText(homeInfo.getAir_quality());
        binding.keyData.setText(homeInfo.getDate());
        binding.keyDressing.setText(homeInfo.getDressing());
        binding.keyTemp.setText(homeInfo.getTemp());
        binding.keySkycon.setText(homeInfo.getSkycon());
        binding.keyUltra.setText(homeInfo.getUltraviolet());
        binding.keyWind.setText(homeInfo.getWind());
        return binding.getRoot();
    }
}
