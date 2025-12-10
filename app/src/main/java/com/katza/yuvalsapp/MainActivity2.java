package com.katza.yuvalsapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    SharedPreferences sp;
    Button btnSave;
    EditText etFname,etLname;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

sp = getSharedPreferences("details1",0);

        initViews();

String strFname = sp.getString("fname",null);
String strLname = sp.getString("lname",null);
if(strLname!=null && strFname!=null){
    tvDisplay.setText("welcome " + strFname + " " + strLname);
}



    }

    private void initViews() {
        btnSave = (Button) findViewById(R.id.btnSubmit);
        etFname = (EditText) findViewById(R.id.etFname);
        etLname = (EditText) findViewById(R.id.etLname);
        tvDisplay = (TextView) findViewById(R.id.tvDisplay);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnSave == v){
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("fname",etFname.getText().toString());
                    editor.putString("lname",etLname.getText().toString());
                    editor.commit();

                }
            }

        });


    }



}