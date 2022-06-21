package com.example.xifeng2.GetContext;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

public class MyApplication extends Application {


    private static Context mContext;
    private static android.os.Handler  handler;
    private int msg_code;
    @Override
    public void onCreate() {
        super.onCreate();
        //获取context
        mContext = getApplicationContext();
        handler=new android.os.Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
            }
        };
    }
    //创建一个静态的方法，以便获取context对象
    public static Context getContext(){
        return mContext;
    }
    public static Handler   getHandler(){return handler;}
}