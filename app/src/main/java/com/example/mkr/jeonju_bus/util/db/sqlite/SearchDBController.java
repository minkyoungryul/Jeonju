package com.example.mkr.jeonju_bus.util.db.sqlite;

import android.database.sqlite.SQLiteDatabase;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by mkr on 2017-08-22.
 */

public class SearchDBController {
    SQLiteDatabase db;
    CompositeSubscription compositeSubscription;
    DBHelper dbHelper;
    public final static String _RECENT_USE_TABLE_NAME = "recent_use";
    public final static String CREATE_RECENT_USE_TABLE = "create table IF NOT EXISTS "+_RECENT_USE_TABLE_NAME+"("
            + "_id integer primary key autoincrement,"
            + "content text,"
            + "reg_date datetime default current_timestamp"
            + ")";

    public SearchDBController(CompositeSubscription compositeSubscription, DBHelper dbHelper){
        this.compositeSubscription = compositeSubscription;
        this.dbHelper = dbHelper;
    }

    public void open(SQLiteDatabase db){
        this.db = db;
    }
}
