package com.example.mkr.jeonju_bus.main.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.example.mkr.jeonju_bus.R;
import com.example.mkr.jeonju_bus.main.data.RecentUseData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkr on 2017-08-21.
 */

public class MainRecentUseAdapter extends RecyclerView.Adapter<MainRecentUseAdapter.ViewHolder> {

    Context mContext;
    List<RecentUseData> datas = new ArrayList<>();

    public MainRecentUseAdapter(Context context, List<RecentUseData> datas) {
        this.mContext = context;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recent_use, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecentUseData data = datas.get(position);

        if(position == 0){
            holder.ll_edit.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout ll_edit;
        public ViewHolder(View itemView) {
            super(itemView);
            ll_edit = (LinearLayout) itemView.findViewById(R.id.ll_edit);
        }
    }
}