package com.example.xifeng2.Startup;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.xifeng2.R;
import com.example.xifeng2.ShareEdit.ShareEdit;
import androidx.annotation.NonNull;

public class startup {
    private static AMapLocationClient mapLocationClient;

    static public void Init(final Context context) throws Exception {
//更新用户隐私配置
        AMapLocationClient.updatePrivacyAgree(context,true);
        AMapLocationClient.updatePrivacyShow(context,true,true);
//初始化变量
        mapLocationClient=new AMapLocationClient(context);
        //初始化操作类型
        AMapLocationClientOption option;
        option=new AMapLocationClientOption();
        option.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTPS);
        option.setOnceLocation(true);
        option.setGpsFirst(true);
        option.setGpsFirstTimeout(5000);
        option.setHttpTimeOut(10000);
        option.setInterval(600000);
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mapLocationClient.setLocationOption(option);
        mapLocationClient=new AMapLocationClient(context.getApplicationContext());

        //新建一个handler
        final Handler handler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what==0x1111){
                    mapLocationClient.stopLocation();
                }
            }
        };

        //设置监听回调
        final AMapLocationListener    listener=new AMapLocationListener() {
            @Override
        synchronized    public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation!=null){
                    if (aMapLocation.getErrorCode()==0) {
                        ShareEdit sharedEdit = new ShareEdit();
                        sharedEdit.InitShareEdit();
                        sharedEdit.SetLongtitude(R.string.经度, aMapLocation.getLongitude());
                        sharedEdit.SetLatitude(R.string.纬度, aMapLocation.getLatitude());
                        sharedEdit.SetCity(R.string.城市, aMapLocation.getCity());
                        sharedEdit.SetDistrict(R.string.区域, aMapLocation.getDistrict());
                        Log.i("TAG1", ": "+aMapLocation.getCity()+aMapLocation.getDistrict());
                        sharedEdit.Commit();
                        Message message = handler.obtainMessage();
                        message.what = 0x1111;
                        handler.sendMessage(message);
                    }
                }
            }
        };
        mapLocationClient.setLocationListener(listener);
        mapLocationClient.disableBackgroundLocation(false);
        mapLocationClient.startLocation();
    }

}
