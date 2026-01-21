package com.katza.yuvalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        Button btnA = findViewById(R.id.btnA);
        Button btnB = findViewById(R.id.btnB);

        // OPEN A
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentA = new Intent("ACTION_TYPE_A");
                startActivity(intentA);
            }
        });

        // OPEN B
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentB = new Intent("ACTION_TYPE_B");
                startActivity(intentB);
            }
        });
    }
}
