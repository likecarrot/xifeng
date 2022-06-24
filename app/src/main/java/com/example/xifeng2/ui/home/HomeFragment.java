package com.example.xifeng2.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.xifeng2.GetContext.MyApplication;
import com.example.xifeng2.R;
import com.example.xifeng2.ShareEdit.ShareEdit;
import com.example.xifeng2.adapter.HomeInfo;
import com.example.xifeng2.adapter.HomeInfo_Adapter;
import com.qmuiteam.qmui.widget.QMUIEmptyView;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private HomeInfo homeInfo;
    private HomeInfo_Adapter homeInfo_adapter;
    private static LinearLayout linearLayout;
    private View root;

    private Handler handler;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
        linearLayout = root.findViewById(R.id.home_container);

        updateUI();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 0x1113;
                handler.sendMessage(message);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 4000);

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                updateUI();
            }
        };

        return root;
    }


    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    void updateUI() {
        Log.i("TAG1", "updateUI:");
        homeInfo = new HomeInfo();
        homeInfo_adapter = new HomeInfo_Adapter(homeInfo);
        homeInfo_adapter.bindViewGroup(linearLayout);
    }
}