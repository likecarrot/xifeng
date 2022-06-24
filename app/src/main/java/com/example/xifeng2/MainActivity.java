package com.example.xifeng2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocationClient;
import com.example.xifeng2.ShareEdit.ShareEdit;
import com.example.xifeng2.Startup.UpdateLocation;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private ShareEdit shareEdit;
    private String[] permissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        //首次启动初始化
        try {
            IsFirstStart();
        } catch (Exception e) {
            e.printStackTrace();
        }

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    void IsFirstStart() throws Exception {
        shareEdit = new ShareEdit();
        if (shareEdit.GetFirstStart() == true) {
            shareEdit.SetFirstStart(); //暂时关闭首次使用
            //dialog
            new QMUIDialog.MessageDialogBuilder(this)
                    .setTitle("提示:如果不允许定位权限则无法正常工作.\n授予权限后请重启APP.")
                    .addAction("知道了", new QMUIDialogAction.ActionListener() {
                        @Override
                        public void onClick(QMUIDialog dialog, int index) {
                            dialog.dismiss();
                            try {
                                Init();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).show();
        } else {
            Log.i("TAG1", "Init: first false");
            new UpdateLocation();
        }
    }

    void Init() {
        //更新用户隐私配置
        AMapLocationClient.updatePrivacyAgree(this, true);
        AMapLocationClient.updatePrivacyShow(this, true, true);

        GetPermissions();
        //请求GPS打开
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (gpsEnabled == false) {
            Toast.makeText(this, "请打开GPS定位", Toast.LENGTH_SHORT).show();
            Intent gpsintent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivityForResult(gpsintent, 0);
        }
        Log.i("TAG1", "Init: first true");

//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                try {
//                    new UpdateLocation();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        Timer timer = new Timer();
//        timer.schedule(timerTask, 3000);
    }

    void GetPermissions() {
        permissions = new String[]{
                //Manifest.permission.ACCESS_COARSE_LOCATION
                Manifest.permission.ACCESS_FINE_LOCATION
//                Manifest.permission.READ_PHONE_STATE
//                Manifest.permission.ACCESS_NETWORK_STATE,
//                Manifest.permission.ACCESS_WIFI_STATE,
//                Manifest.permission.CHANGE_WIFI_STATE,
//                Manifest.permission.INTERNET,
//                Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS
                };
        //List<String> pl = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {
                //pl.add(permission);
                ActivityCompat.requestPermissions(this,permissions,1);
            }
//            if (pl.size() > 0)
//                ActivityCompat.requestPermissions(this, pl.toArray(new String[0]), 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        int grantCode = 0;
        if (requestCode == 1) {
            for (int grant : grantResults) {
                if (grant == PackageManager.PERMISSION_GRANTED) {
                    grantCode++;
                }
            }
            if (grantCode == grantResults.length) {
                Log.i("TAG1", "onRequestPermissionsResult: 权限充足" + permissions);
                try {
                    new UpdateLocation();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else
                Toast.makeText(this, "权限不足", Toast.LENGTH_SHORT).show();
        }
    }
}