package com.techcrevices.serviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.buttonStart)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startService(new Intent(MainActivity.this, MyService.class));
            }
        });


        ((Button)findViewById(R.id.buttonStop)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopService(new Intent(MainActivity.this, MyService.class));

            }
        });

        ((Button)findViewById(R.id.is)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, IntentServiceActivity.class));

            }
        });



    }
}
