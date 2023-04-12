package com.example.myapplication;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;


public class MyReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST="ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction=intent.getAction();
        if (intentAction!=null){
            String msg="Unknown Intent";
            switch (intentAction)
            {
                case Intent.ACTION_BATTERY_LOW:
                    msg="Battery Low";
                    break;
                case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                    msg="Airplane mode changed!!";
                    break;
                case Intent.ACTION_POWER_CONNECTED:
                    msg="Power Connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    msg="Power Disconnected";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    msg="Custom Broadcast Received";
                    break;
            }
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }
    }
}