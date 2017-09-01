package com.example.mkr.jeonju_bus.search.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mkr.jeonju_bus.R;
import com.example.mkr.jeonju_bus.search.data.BusStopData;
import com.example.mkr.jeonju_bus.search.presenter.BusStopListPresenter;
import com.example.mkr.jeonju_bus.util.Logger;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mkr on 2017-09-01.
 */

public class BusStopListActivity extends FragmentActivity implements OnMapReadyCallback , BusStopListView{

    GoogleMap map;
    double mLatitude = 35.8241932;
    double mLongitude = 127.1480005;

    LocationManager locationManager;
    boolean isGPSEnabled = false;
    boolean isNetWorkEnabled = false;
    SupportMapFragment mapFragment;
    String currentLocationAddress;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    LinearLayoutManager mLayoutManager;
    BusStopListAdapter adapter;
    List<BusStopData> busStopDataList = new ArrayList<>();

    BusStopListPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_stop_list);
        ButterKnife.bind(this);

        presenter = new BusStopListPresenter();
        presenter.attachView(this);

        init();
        setListener();
    }


    private void init() {

        presenter.getBusStopList();

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);

        for(int i=0; i<10; i++){
            busStopDataList.add(new BusStopData());
        }
        mLayoutManager = new LinearLayoutManager(this);
        adapter = new BusStopListAdapter(this,busStopDataList);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        //GPS가 켜져있는지 체크
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            //GPS 설정화면으로 이동
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            startActivity(intent);
            finish();
        }

        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetWorkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        Logger.log("#5 GPS->" + isGPSEnabled + "," + isNetWorkEnabled);

        //마시멜로 이상이면 권한 요청하기
        if (Build.VERSION.SDK_INT >= 23) {
            //권한이 없는 경우
            if (ContextCompat.checkSelfPermission(BusStopListActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(BusStopListActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(BusStopListActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
            //권한이 있는 경우
            else {
                requestMyLocation();
            }
        }
        //마시멜로 아래
        else {
            requestMyLocation();
        }
    }

    private void setListener() {
    }

    //권한 요청후 응답 콜백
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //ACCESS_COARSE_LOCATION 권한
        if (requestCode == 1) {
            //권한받음
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                requestMyLocation();
            }
            //권한못받음
            else {
                Toast.makeText(this, "권한없음", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    public void requestMyLocation() {
        Logger.log("#5");
        if (ContextCompat.checkSelfPermission(BusStopListActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(BusStopListActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //요청
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1, locationListener);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);

    }

    //위치정보 구하기 리스너
    LocationListener locationListener = new LocationListener() {
        //현재 여기 안들어옴
        @Override
        public void onLocationChanged(Location location) {
            Logger.log("#6 1");
            if (ContextCompat.checkSelfPermission(BusStopListActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(BusStopListActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            //나의 위치를 한번만 가져오기 위해
            locationManager.removeUpdates(locationListener);

            //위도 경도
            mLatitude = location.getLatitude();   //위도
            mLongitude = location.getLongitude(); //경도
            Logger.log("#10 mLatitude ->" + mLatitude + ", " + mLongitude);
//            findAddress(mLatitude, mLongitude);

//            맵생성
//            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//            콜백클래스 설정
            mapFragment.getMapAsync(BusStopListActivity.this);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Logger.log("#6 2");
        }

        @Override
        public void onProviderEnabled(String provider) {
            Logger.log("#6 3");
        }

        @Override
        public void onProviderDisabled(String provider) {
            Logger.log("#6 4");
        }
    };

    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;
        this.map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        this.map.setMyLocationEnabled(true);
        this.map.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                requestMyLocation();
                return true;
            }
        });

        LatLng position = new LatLng(mLatitude, mLongitude);
        Logger.log("#10 location ->"+mLatitude+", "+mLongitude + ", position ->"+position);

//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(position);
//        markerOptions.title("현재 위치");
//        map.addMarker(markerOptions);

        this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 15));
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void notConnectNetworking() {

    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
