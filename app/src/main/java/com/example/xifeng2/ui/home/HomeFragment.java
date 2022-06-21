package com.example.xifeng2.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.xifeng2.GetContext.MyApplication;
import com.example.xifeng2.R;
import com.example.xifeng2.ShareEdit.ShareEdit;
import com.example.xifeng2.adapter.HomeInfo;
import com.example.xifeng2.adapter.HomeInfo_Adapter;

public class HomeFragment extends Fragment {

    private HomeInfo homeInfo;
    private HomeInfo_Adapter homeInfo_adapter;
    private LinearLayout linearLayout;
    private Handler myhandler;
    private ShareEdit shareEdit;
    private View root;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
        linearLayout = root.findViewById(R.id.home_container);

        shareEdit = new ShareEdit();
        shareEdit.InitShareEdit();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeInfo = new HomeInfo();
        homeInfo_adapter = new HomeInfo_Adapter(homeInfo);
        homeInfo_adapter.bindViewGroup(linearLayout);
    }

}