package com.example.xifeng2.Startup;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

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
        for (int i=0;i<permissions.length;i++){
            if (activity.checkSelfPermission(permissions[i])!=PackageManager.PERMISSION_GRANTED){
                activity.requestPermissions(permissions,1);

            }
        }
    }
}
