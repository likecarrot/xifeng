package com.example.xifeng2.Startup;

import android.util.Log;
import android.widget.Toast;

import com.example.xifeng2.ApiServers.ApiServers;
import com.example.xifeng2.GetContext.MyApplication;
import com.example.xifeng2.RetClass.realtime;
import com.example.xifeng2.ShareEdit.ShareEdit;
import com.example.xifeng2.adapter.HomeInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateWeatherInfo {


            public UpdateWeatherInfo(){
                ShareEdit shareEdit=new ShareEdit();
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl("https://api.caiyunapp.com/v2.5/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiServers apiServers=retrofit.create(ApiServers.class);
                Call<realtime> call=apiServers.GetRealTime("tsmEhYjMZBN6FErG", shareEdit.GetLongtitude(),  shareEdit.GetLatitude());
                call.enqueue(new Callback<realtime>() {
                    @Override
                    public void onResponse(Call<realtime> call, Response<realtime> response) {
                        Log.i("TAG", "onResponse: "+response.code());
                        if (response.code()!=200){

                        }else{
                            assert response.body() != null;
                            new HomeInfo(response.body());
                            Log.i("TAG1", "onUpdateWeatherInfo success");
                            Toast.makeText(MyApplication.getContext(), "天气更新成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<realtime> call, Throwable throwable) {

                    }
                });
            }
}
