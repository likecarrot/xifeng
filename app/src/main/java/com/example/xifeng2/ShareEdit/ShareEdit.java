package com.example.xifeng2.ShareEdit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import com.example.xifeng2.R;

import java.util.Map;
import java.util.Set;

import androidx.annotation.Nullable;

public class ShareEdit {
    private SharedPreferences.Editor    editor;
    private SharedPreferences   sharedPreferences;
    private Context context;
    public void InitShareEdit(Context context){
        sharedPreferences=context.getSharedPreferences("xifeng",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        this.context=context;
    }
    public void SetLongtitude(int key,double in){
        editor.putFloat(context.getResources().getString(R.string.经度),(float)in);
    }
    public void SetLatitude(int key,double in){
        editor.putFloat(context.getResources().getString(R.string.纬度),(float)in);
    }
    public void SetCity(int key,String in){
        editor.putString(context.getResources().getString(R.string.城市),in);
    }
    public String   GetCity(int key,String Defaultin){
        return sharedPreferences.getString(context.getResources().getString(R.string.城市),Defaultin);
    }

    public float GetLongtitude(int key,float Defaultin){
        return sharedPreferences.getFloat(context.getResources().getString(R.string.经度),Defaultin);
    }
    public float GetLatitude(int key,float Defaultin){
        return sharedPreferences.getFloat(context.getResources().getString(R.string.纬度),Defaultin);
    }




    public void Commit(){
        editor.commit();
    }
    public void clearEdit(String key) {
        editor.clear();
    }
}
