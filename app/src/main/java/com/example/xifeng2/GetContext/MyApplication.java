package com.example.xifeng2.GetContext;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

public class MyApplication extends Application {


    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        //获取context
        mContext = getApplicationContext();

    }

    //创建一个静态的方法，以便获取context对象
    public static Context getContext(){
        return mContext;
    }
}