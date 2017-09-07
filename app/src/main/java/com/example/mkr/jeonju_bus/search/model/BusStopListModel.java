package com.example.mkr.jeonju_bus.search.model;

import android.content.Context;

import com.example.mkr.jeonju_bus.search.data.BusStopList;
import com.example.mkr.jeonju_bus.search.data.BusStopListInfo;
import com.example.mkr.jeonju_bus.util.Logger;
import com.example.mkr.jeonju_bus.util.Variable;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

import io.reactivex.Maybe;

/**
 * Created by mkr on 2017-09-01.
 */

public class BusStopListModel {

    Context mContext;

    public BusStopListModel(Context context){
        mContext = context;
    }


    public Maybe<BusStopListInfo> getBusStopList() {
        HashMap<String, String> param = new HashMap<>();
        param.put("ServiceKey", Variable._SERVICE_KEY);
        return BusStopListApiService.Factory.create().getBusStopList(param);
//        return BusStopListApiService.Factory.create().getBusStopList(Variable._SERVICE_KEY);
    }
}
