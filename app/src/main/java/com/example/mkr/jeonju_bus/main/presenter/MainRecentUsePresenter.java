package com.example.mkr.jeonju_bus.main.presenter;

import android.content.Context;

import com.example.mkr.jeonju_bus.GlobalApplication;
import com.example.mkr.jeonju_bus.common.presenter.Presenter;
import com.example.mkr.jeonju_bus.main.view.MainRecentUseView;
import com.example.mkr.jeonju_bus.util.db.sqlite.DBHelper;

/**
 * Created by mkr on 2017-08-22.
 */

public class MainRecentUsePresenter implements Presenter<MainRecentUseView> {

    MainRecentUseView view;
    Context mContext;
    DBHelper dbHelper;

    @Override
    public void attachView(MainRecentUseView view) {
        this.view = view;
        mContext = view.getContext();
        dbHelper = DBHelper.getInstance(mContext);
        dbHelper.openDB();
    }

    @Override
    public void detachView() {
        view = null;
        dbHelper.closeDB();
    }

    @Override
    public void notConnectNetworking() {
        this.notConnectNetworking();
    }
}
