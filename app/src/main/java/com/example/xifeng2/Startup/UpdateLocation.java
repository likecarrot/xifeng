package com.example.xifeng2.Startup;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.xifeng2.GetContext.MyApplication;
import com.example.xifeng2.ShareEdit.ShareEdit;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;

public class UpdateLocation {
    private static AMapLocationClient mapLocationClient;
    private Context context;
    private Handler handler;

    public UpdateLocation() throws Exception {
        do {
            context = MyApplication.getContext();
            Log.i("TAG1", "UpdateLocation: 开始执行");
            //判断是否打开GPS功能
            LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            if (gpsEnabled == false) {
                Toast.makeText(context, "请打开GPS定位", Toast.LENGTH_SHORT).show();
                break;
            }
            //初始化变量
            mapLocationClient = new AMapLocationClient(context);
            //初始化操作类型
            AMapLocationClientOption option;
            option = new AMapLocationClientOption();
            option.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTPS);
            option.setOnceLocation(false);
            option.setGpsFirst(true);
            option.setGpsFirstTimeout(8000);
            option.setHttpTimeOut(8000);
            option.setInterval(2000);
            option.setOnceLocationLatest(true);
            option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            mapLocationClient.setLocationOption(option);

            final AMapLocationListener listener = new AMapLocationListener() {
                @Override
                synchronized public void onLocationChanged(AMapLocation aMapLocation) {
                    if (aMapLocation != null) {
                        if (aMapLocation.getErrorCode() == 0) {
                            ShareEdit sharedEdit = new ShareEdit();
                            sharedEdit.SetLongtitude(aMapLocation.getLongitude());
                            sharedEdit.SetLatitude(aMapLocation.getLatitude());
                            sharedEdit.SetCity(aMapLocation.getCity());
                            sharedEdit.SetDistrict(aMapLocation.getDistrict());
                            Log.i("TAG1", ":onUpdateLocationinfo " + aMapLocation.getCity() + aMapLocation.getDistrict());
                            sharedEdit.Commit();
                            Toast.makeText(context, "定位更新成功", Toast.LENGTH_SHORT).show();
                            Message msg=handler.obtainMessage(0x1111);
                            msg.sendToTarget();
                            new UpdateWeatherInfo();
                        } else {
                            Toast.makeText(context, "定位更新失败", Toast.LENGTH_SHORT).show();
                            Log.i("TAG1", "onLocationChanged: updatelocation--amaplocation error==" + aMapLocation.getErrorCode() + aMapLocation.getErrorInfo());
                        }
                    }
                }
            };

            mapLocationClient.setLocationListener(listener);
            mapLocationClient.disableBackgroundLocation(false);
            mapLocationClient.startLocation();
            Log.i("TAG1", "UpdateLocation: 正在更新定位...");

        }while(false);
        //新建一个handler,用来接收消息实现关闭定位请求
        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0x1111) {
                    Log.i("TAG1", "handleMessage: 收到0x1111");
                    mapLocationClient.stopLocation();
                    new UpdateWeatherInfo();
                }
                if (msg.what==0x1109){
                    mapLocationClient.startLocation();
                    Log.i("TAG1", "handleMessage: 收到0x1109");
                }
            }
        };
    }
}
