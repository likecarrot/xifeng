package com.example.xifeng2.Startup;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;

import com.example.xifeng2.GetContext.MyApplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class GetPermission {
    private String[] permissions=new String[]{
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.INTERNET,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS
    };
    public GetPermission(Activity activity){
        List<String> pl=new ArrayList<>();
        for (String permission:permissions){
            if (ContextCompat.checkSelfPermission(MyApplication.getContext(),permission)!=PackageManager.PERMISSION_GRANTED){
                pl.add(permission);
            }
        }if (pl.size()>0)
        ActivityCompat.requestPermissions(activity,pl.toArray(new String[0]),1);
    }
}
