package com.example.xifeng2.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.xifeng2.ApiServers.ApiServers;
import com.example.xifeng2.GetContext.MyApplication;
import com.example.xifeng2.R;
import com.example.xifeng2.RetClass.realtime;
import com.example.xifeng2.ShareEdit.ShareEdit;
import com.example.xifeng2.Startup.UpdateLocation;
import com.example.xifeng2.Startup.UpdateWeatherInfo;
import com.example.xifeng2.adapter.HomeInfo;

public class DashboardFragment extends Fragment implements View.OnClickListener{

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case    R.id.dash_update_location:
                try {
                    new UpdateLocation();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case    R.id.dash_update_weather:
                new UpdateWeatherInfo();
                break;
        }
    }

    private TextView    update_weather,update_location;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        update_weather=root.findViewById(R.id.dash_update_weather);
        update_location=root.findViewById(R.id.dash_update_location);

        update_location.setOnClickListener(this);
        update_weather.setOnClickListener(this);


        return root;
    }
}