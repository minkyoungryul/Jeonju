package com.example.mkr.jeonju_bus.search.model;

import com.example.mkr.jeonju_bus.search.data.BusStopData;
import com.example.mkr.jeonju_bus.search.data.BusStopListInfo;
import com.example.mkr.jeonju_bus.util.RetrofitFactory;
import com.example.mkr.jeonju_bus.util.Variable;

import java.util.Map;

import io.reactivex.Maybe;
import retrofit2.Converter;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by mkr on 2017-09-01.
 */

public interface BusStopListApiService {
    @GET(Variable._SERVER_REQUEST_URL)
    Maybe<BusStopListInfo> getBusStopList(@QueryMap Map<String, String> map);

    class Factory extends Converter.Factory{
        public static BusStopListApiService create(){
            return  RetrofitFactory.initRetrofit().create(BusStopListApiService.class);
        }
    }
}
