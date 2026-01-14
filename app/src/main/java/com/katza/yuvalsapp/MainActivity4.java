package com.katza.yuvalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    EditText etName, etAge, etAmount;
    RadioGroup radioGroupGender;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etAmount = findViewById(R.id.etAmount);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());
                double amountShk = Double.parseDouble(etAmount.getText().toString());

                int selectedId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                boolean isMale = selectedRadioButton.getText().toString().equals("זכר");

                Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                intent.putExtra("name", name);
                intent.putExtra("age", age);
                intent.putExtra("isMale", isMale);
                intent.putExtra("amountShk", amountShk);

                startActivity(intent);
            }
        });
    }
}
