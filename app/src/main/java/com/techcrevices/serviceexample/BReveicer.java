package com.techcrevices.serviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BReveicer extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String s = intent.getStringExtra("cashback");
        Toast.makeText(context,""+s,Toast.LENGTH_LONG).show();
    }
}
