package com.example.mkr.jeonju_bus.search.presenter;

import android.content.Context;

import com.example.mkr.jeonju_bus.common.presenter.Presenter;
import com.example.mkr.jeonju_bus.search.data.BusStopData;
import com.example.mkr.jeonju_bus.search.model.BusStopListModel;
import com.example.mkr.jeonju_bus.search.view.BusStopListView;
import com.example.mkr.jeonju_bus.util.Logger;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mkr on 2017-09-01.
 */

public class BusStopListPresenter implements Presenter<BusStopListView> {

    BusStopListView view;
    CompositeDisposable compositeDisposable;
    BusStopListModel model;
    Context mContext;

    @Override
    public void attachView(BusStopListView view) {
        this.view = view;
        mContext = view.getContext();
        model = new BusStopListModel(mContext);
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        view = null;
        compositeDisposable.clear();
    }

    @Override
    public void notConnectNetworking() {
        view.notConnectNetworking();
    }

    public void getBusStopList() {
        Disposable disposable = model.getBusStopList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BusStopData>() {
                    @Override
                    public void accept(BusStopData busStopData) throws Exception {
                        Logger.log("#13 busStopData->"+busStopData.toString());
                    }
                });
    }
}
