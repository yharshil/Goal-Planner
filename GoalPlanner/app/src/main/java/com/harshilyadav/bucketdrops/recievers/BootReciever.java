package com.harshilyadav.bucketdrops.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.harshilyadav.bucketdrops.extras.utils;

public class BootReciever extends BroadcastReceiver {
    public static final String TAG="VIVZ";
    public BootReciever() {
        Log.d(TAG, "BootReceiver: ");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        utils.scheduleAlarm(context);
    }
}

