package com.katza.yuvalsapp;

import android.app.Dialog;
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
    Button btnOpenDialog;
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

        sp = getSharedPreferences("details1", MODE_PRIVATE);

        initViews();
        loadSavedName();
    }

    private void initViews() {
        btnOpenDialog = findViewById(R.id.btnSubmit);
        tvDisplay = findViewById(R.id.tvDisplay);

        btnOpenDialog.setOnClickListener(v -> openCustomDialog());
    }

    private void loadSavedName() {
        String fname = sp.getString("fname", null);
        String lname = sp.getString("lname", null);

        if (fname != null && lname != null) {
            tvDisplay.setText("welcome " + fname + " " + lname);
        }
    }

    private void openCustomDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_layout);
        dialog.setCancelable(true);

        EditText etFname = dialog.findViewById(R.id.etFnameDialog);
        EditText etLname = dialog.findViewById(R.id.etLnameDialog);
        Button btnSend = dialog.findViewById(R.id.btnDialogSend);

        btnSend.setOnClickListener(v -> {
            String fname = etFname.getText().toString();
            String lname = etLname.getText().toString();

            SharedPreferences.Editor editor = sp.edit();
            editor.putString("fname", fname);
            editor.putString("lname", lname);
            editor.apply();

            tvDisplay.setText("welcome " + fname + " " + lname);
            dialog.dismiss();
        });

        dialog.show();
    }
}
