package com.katza.yuvalsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    TextView tvResult;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvResult = findViewById(R.id.tvResult);
        btnOk = findViewById(R.id.btnOk);

        // שליפה מה־Intent
        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", 0);
        boolean isMale = getIntent().getBooleanExtra("isMale", true);
        double amountShk = getIntent().getDoubleExtra("amountShk", 0);

        // המרה לדולרים
        double amountUsd = amountShk / 3.2;

        String genderText = isMale ? "זכר" : "לא זכר";

        // הצגה בטקסט
        String resultText = "שלום: " + name +
                "\nגיל: " + age +
                "\nמין: " + genderText +
                "\nסכום: ₪" + amountShk + " = $" + String.format("%.2f", amountUsd);

        tvResult.setText(resultText);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // סוגר את הדף וחוזר לראשון
            }
        });
    }
}
