package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    private MyReceiver myReceiver = new MyReceiver();

    private static final String ACTION_CUSTOM_BROADCAST = "ACTION_CUSTOM_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        this.registerReceiver(myReceiver, filter);
        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));
        btn = findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent custom_intent = new Intent(ACTION_CUSTOM_BROADCAST);
                LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(custom_intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(myReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver);
        super.onDestroy();
    }
}