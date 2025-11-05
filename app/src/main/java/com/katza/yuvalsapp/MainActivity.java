package com.katza.yuvalsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Switch switch1;
    private ImageView like;
    private SeekBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // התאמת padding למערכת
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // אתחול views
        unitViews();

        // הגדרת Switch
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                like.setVisibility(View.VISIBLE);
            } else {
                like.setVisibility(View.INVISIBLE);
            }
        });

        // הגדרת SeekBar
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float alpha = progress / 100f;  // ממיר ל-0.0 - 1.0
                like.setAlpha(alpha);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // התחל את ה-ImageView כנסתר
        like.setVisibility(View.INVISIBLE);
    }

    private void unitViews() {
        switch1 = findViewById(R.id.switch1);
        like = findViewById(R.id.like);
        bar = findViewById(R.id.Bar);  // חשוב! עכשיו SeekBar מאותחל
    }
}
