package com.example.mkr.jeonju_bus.search.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.mkr.jeonju_bus.R;
import com.example.mkr.jeonju_bus.search.data.SearchData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mkr on 2017-08-23.
 */

public class SearchActivity extends AppCompatActivity{

    @BindView(R.id.ib_back)
    ImageButton ib_back;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.ll_search_delete)
    LinearLayout ll_search_delete;

    @BindView(R.id.ib_map)
    ImageButton ib_map;

    @BindView(R.id.ib_search)
    ImageButton ib_search;

    @BindView(R.id.et_search)
    EditText et_search;

    LinearLayoutManager mLayoutManager;
    SearchAdapter adapter;
    List<SearchData> searchDataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        init();
        setListener();
    }

    private void init() {
        searchDataList = new ArrayList<>();
        for(int i=0; i<10; i++){
            searchDataList.add(new SearchData());
        }

        mLayoutManager = new LinearLayoutManager(this);
        adapter = new SearchAdapter(this, searchDataList);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void setListener() {
        ib_back.setOnClickListener(v->finish());
        ib_map.setOnClickListener(v->{
            Intent intent = new Intent(SearchActivity.this, MapActivity.class);
            startActivity(intent);
        });
        ib_search.setOnClickListener(v->{
            Intent intent = new Intent(SearchActivity.this, BusStopListActivity.class);
            startActivity(intent);
        });
    }
}
