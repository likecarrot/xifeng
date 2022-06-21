package com.example.xifeng2;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.xifeng2.ApiServers.ApiServers;
import com.example.xifeng2.GetContext.MyApplication;
import com.example.xifeng2.RetClass.realtime;
import com.example.xifeng2.ShareEdit.ShareEdit;
import com.example.xifeng2.Startup.startup;
import com.example.xifeng2.adapter.HomeInfo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


        private ShareEdit   shareEdit;
        private HomeInfo    homeInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        try {
            startup.Init(MainActivity.this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {

                shareEdit=new ShareEdit();
                shareEdit.InitShareEdit();
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl("https://api.caiyunapp.com/v2.5/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiServers apiServers=retrofit.create(ApiServers.class);
                Call<realtime>  call=apiServers.GetRealTime("tsmEhYjMZBN6FErG", shareEdit.GetLongtitude(R.string.经度,115.2545f),  shareEdit.GetLatitude(R.string.纬度,33.5355f));
                call.enqueue(new Callback<realtime>() {
                    @Override
                    public void onResponse(Call<realtime> call, Response<realtime> response) {
                        Log.i("TAG", "onResponse: "+response.code());
                        if (response.code()!=200){

                        }else{
                            assert response.body() != null;
                            homeInfo=new HomeInfo(response.body());
                            Toast.makeText(MyApplication.getContext(), "Success", Toast.LENGTH_SHORT).show();
                            MyApplication.getHandler().obtainMessage(0x1112).sendToTarget();
                        }
                    }
                    @Override
                    public void onFailure(Call<realtime> call, Throwable throwable) {

                    }
                });

            }
        }).start();
    }

}