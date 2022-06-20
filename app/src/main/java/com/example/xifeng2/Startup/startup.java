package com.example.xifeng2.Startup;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
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
    static public void Init(final Context context) throws Exception {
        AMapLocationClient.updatePrivacyAgree(context,true);
        AMapLocationClient.updatePrivacyShow(context,true,true);

        AMapLocationClient mapLocationClient=new AMapLocationClient(context);
        AMapLocationClientOption option;

        option=new AMapLocationClientOption();
        option.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTPS);
        option.setOnceLocation(true);
        option.setGpsFirst(true);
        option.setGpsFirstTimeout(5000);
        option.setHttpTimeOut(10000);
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mapLocationClient.setLocationOption(option);
        mapLocationClient=new AMapLocationClient(context.getApplicationContext());
        AMapLocationListener    listener=new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation!=null){
                    if (aMapLocation.getErrorCode()==0){
                        ShareEdit  sharedEdit=new ShareEdit();
                        sharedEdit.InitShareEdit(context);
                        sharedEdit.SetLongtitude(R.string.经度,aMapLocation.getLongitude());
                        sharedEdit.SetLatitude(R.string.纬度,aMapLocation.getLatitude());
                        sharedEdit.SetCity(R.string.城市,aMapLocation.getCity());
                        sharedEdit.Commit();
                        Log.d("startup", "经度-"+aMapLocation.getLongitude()+"纬度-"+aMapLocation.getLatitude()+"城市"+aMapLocation.getCity());
                        Toast.makeText(context, "经度-"+aMapLocation.getLongitude()+"纬度-"+aMapLocation.getLatitude()+"城市"+aMapLocation.getCity(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(context,"Init Failed",Toast.LENGTH_SHORT).show();
                }
            }
        };
        mapLocationClient.setLocationListener(listener);
        mapLocationClient.disableBackgroundLocation(false);
        mapLocationClient.startLocation();
    }
}
