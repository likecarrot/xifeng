package com.example.xifeng2.ShareEdit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.example.xifeng2.GetContext.MyApplication;
import com.example.xifeng2.R;

import java.util.Map;
import java.util.Set;

import androidx.annotation.Nullable;

public class ShareEdit {
    private SharedPreferences.Editor    editor;
    private SharedPreferences   sharedPreferences;
    private Context context;
    public ShareEdit(){
        this.context= MyApplication.getContext();
        sharedPreferences=context.getSharedPreferences("xifeng",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }


    public String   GetKeyString(int key,String defaultin){
        return sharedPreferences.getString(context.getResources().getString(key),defaultin);
    }
    public void     SetKeyString(int key,String in){
        editor.putString(context.getResources().getString(key),in);
    }
    public void SetKeyInt(int k,int defaultin){
        editor.putInt(context.getResources().getString(k),defaultin);
    }
    public int  GetKeyInt(int k ,int defaultin){
        return sharedPreferences.getInt(context.getResources().getString(k),defaultin);
    }


    public void SetLongtitude(double in){
        editor.putFloat(context.getResources().getString(R.string.经度),(float)in);
    }
    public void SetLatitude(double in){
        editor.putFloat(context.getResources().getString(R.string.纬度),(float)in);
    }

    public void SetCity(String in){
        editor.putString(context.getResources().getString(R.string.城市),in);
    }
    public void SetDistrict(String in){
        editor.putString(context.getResources().getString(R.string.区域),in);
    }

    public String   GetDistrict(){
        return sharedPreferences.getString(context.getResources().getString(R.string.区域),"郸城县(默认)");
    }
    public String   GetCity(){
        return sharedPreferences.getString(context.getResources().getString(R.string.城市),"周口市(默认)");
    }

    public float GetLongtitude(){
        return sharedPreferences.getFloat(context.getResources().getString(R.string.经度),115.2545f);
    }
    public float GetLatitude(){
        return sharedPreferences.getFloat(context.getResources().getString(R.string.纬度),33.5355f);
    }
    public boolean  GetFirstStart(){
        return sharedPreferences.getBoolean(context.getResources().getString(R.string.首次运行),true);
    }
    public void     SetFirstStart(){
        editor.putBoolean(context.getResources().getString(R.string.首次运行),false);
        editor.commit();
    }



    public void Commit(){
        editor.commit();
    }
    public void clearEdit(String key) {
        editor.clear();
    }
}
