package com.example.xifeng2.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.xifeng2.Startup.startup;
import com.example.xifeng2.adapter.HomeInfo;
import com.example.xifeng2.adapter.HomeInfo_Adapter;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private HomeInfo    homeInfo;
    private HomeInfo_Adapter    homeInfo_adapter;
    private Handler handler;
    private LinearLayout    linearLayout;

    private ShareEdit   shareEdit;

    private View    root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {


        root = inflater.inflate(R.layout.fragment_home, container, false);
        linearLayout=root.findViewById(R.id.home_container);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//
        shareEdit=new ShareEdit();
        shareEdit.InitShareEdit();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        handler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what==0x1112){
                    homeInfo_adapter=new HomeInfo_Adapter(getContext(),homeInfo);
                    homeInfo_adapter.getItem(linearLayout);
                }
            }
        };

        Retrofit    retrofit=new Retrofit.Builder()
                .baseUrl("https://api.caiyunapp.com/v2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServers  apiServers=retrofit.create(ApiServers.class);
        Call<realtime>  call=apiServers.GetRealTime("tsmEhYjMZBN6FErG", shareEdit.GetLongtitude(R.string.经度,115.2545f),  shareEdit.GetLatitude(R.string.纬度,33.5355f));
        call.enqueue(new Callback<realtime>() {
            @Override
            public void onResponse(Call<realtime> call, Response<realtime> response) {
                Log.i("TAG", "onResponse: "+response.code());
                if (response.code()!=200){

                }else{
                    assert response.body() != null;
                    homeInfo=new HomeInfo(response.body());
                    Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                    Message message=handler.obtainMessage();
                    message.what=0x1112;
                    message.sendToTarget();
                }
            }
            @Override
            public void onFailure(Call<realtime> call, Throwable throwable) {

            }
        });

    }
}