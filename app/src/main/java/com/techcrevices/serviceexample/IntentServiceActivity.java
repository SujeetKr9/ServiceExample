package com.techcrevices.serviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IntentServiceActivity extends AppCompatActivity {
    private CashbackReciver cashbackReciver;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        tv = (TextView) findViewById(R.id.cb_results);

        // broadcast receive with class
        //registerCashbackReceiver();


        // broadcst receive without any class
        IntentFilter filter = new IntentFilter(MyIntentService.CASHBACK_INFO);
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String value =  intent.getExtras().getString("cashback");
                Toast.makeText(IntentServiceActivity.this,value,Toast.LENGTH_LONG).show();
            }
        };
        registerReceiver(receiver, filter);

    }
        @Override
        protected void onStop() {
            super.onStop();
            unregisterReceiver(cashbackReciver);
        }
        public void startCashbackService(View view){
            EditText et = (EditText) findViewById(R.id.cashback_cat);

            Intent cbIntent =  new Intent();
            cbIntent.setClass(this, MyIntentService.class);
            cbIntent.putExtra("cashback_cat", et.getText().toString());
            startService(cbIntent);
        }

        private class CashbackReciver extends BroadcastReceiver {
            @Override
            public void onReceive(Context context, Intent intent) {
                String cbinfo = intent.getStringExtra("cashback");
                tv.setText(cbinfo);
            }
        }

    }
