package com.example.mkr.jeonju_bus.search.model;

import android.content.Context;

import com.example.mkr.jeonju_bus.search.data.BusStopData;
import com.example.mkr.jeonju_bus.util.Variable;

import java.util.HashMap;

import io.reactivex.Maybe;
import io.reactivex.disposables.Disposable;

/**
 * Created by mkr on 2017-09-01.
 */

public class BusStopListModel {

    Context mContext;

    public BusStopListModel(Context context){
        mContext = context;
    }


    public Maybe<BusStopData> getBusStopList() {
        HashMap<String, String> param = new HashMap<>();
        param.put("ServiceKey", Variable._SERVICE_KEY);

        return BusStopListApiService.Factory.create().getBusStopList(param);
    }
}
