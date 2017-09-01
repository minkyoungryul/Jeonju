package com.example.mkr.jeonju_bus.search.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mkr.jeonju_bus.R;
import com.example.mkr.jeonju_bus.search.data.BusStopData;

import java.util.List;

/**
 * Created by mkr on 2017-09-01.
 */

public class BusStopListAdapter extends RecyclerView.Adapter<BusStopListAdapter.ViewHolder>{

    Context mContext;
    List<BusStopData> datas;

    public BusStopListAdapter(Context mContext, List<BusStopData> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_bus_stop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
