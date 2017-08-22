package com.example.mkr.jeonju_bus.intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.mkr.jeonju_bus.R;
import com.example.mkr.jeonju_bus.main.view.MainActivity;
import com.facebook.stetho.Stetho;


/**
 * Created by mkr on 2017-08-21.
 */


public class IntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);

        Stetho.initializeWithDefaults(this);

        Handler mHanlder = new Handler();
        mHanlder.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }
}
