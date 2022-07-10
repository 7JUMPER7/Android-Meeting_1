package com.example.firststepapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    private long LOADTIMER = 0;
    private long EXITTIMER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "CREATED");
        LOADTIMER = System.currentTimeMillis();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "STARTED");
        if(LOADTIMER != 0) {
            long diff = System.currentTimeMillis() - LOADTIMER;
            Log.d(TAG, "from CREATED to STARTED ---> " + diff + "ms.");
        }
        LOADTIMER = System.currentTimeMillis();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "RESUMED");
        long diff = System.currentTimeMillis() - LOADTIMER;
        Log.d(TAG, "from STARTED to RESUMED ---> " + diff + "ms.");
        LOADTIMER = 0;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "PAUSED");
        EXITTIMER = System.currentTimeMillis();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "STOPPED");
        long diff = System.currentTimeMillis() - EXITTIMER;
        Log.d(TAG, "from PAUSED to STOPPED ---> " + diff + "ms.");
        EXITTIMER = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "DESTROYED");
        long diff = System.currentTimeMillis() - EXITTIMER;
        Log.d(TAG, "from STOPPED to DESTROYED ---> " + diff + "ms.");
        EXITTIMER = 0;
    }



    public void onClickHandler(View view) {
        Log.d(TAG, "Button pressed!");
    }
}