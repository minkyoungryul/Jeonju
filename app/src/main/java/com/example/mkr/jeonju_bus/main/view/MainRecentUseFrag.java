package com.example.mkr.jeonju_bus.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.mkr.jeonju_bus.R;
import com.example.mkr.jeonju_bus.main.data.RecentUseData;
import com.example.mkr.jeonju_bus.main.presenter.MainRecentUsePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mkr on 2017-08-21.
 */

public class MainRecentUseFrag extends Fragment implements MainRecentUseView{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    LinearLayoutManager mLayoutManager;
    MainRecentUseAdapter adapter;
    List<RecentUseData> datas = new ArrayList<>();

    MainRecentUsePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_recyclerview, container, false);
        ButterKnife.bind(this, view);

        mLayoutManager = new LinearLayoutManager(getContext());
        adapter = new MainRecentUseAdapter(getContext(), datas);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainRecentUsePresenter();
        presenter.attachView(this);
        init();
    }

    private void init() {
        for(int i=0; i<10; i++){
            datas.add(new RecentUseData());
        }
    }

    @Override
    public void notConnectNetworking() {

    }

    @Override
    public void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}