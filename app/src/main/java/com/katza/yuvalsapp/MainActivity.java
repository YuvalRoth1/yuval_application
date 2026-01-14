package com.katza.yuvalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

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

        like.setVisibility(View.INVISIBLE);
    }

    private void unitViews() {
        switch1 = findViewById(R.id.switch1);
        like = findViewById(R.id.like);
        registerForContextMenu(like);
        bar = findViewById(R.id.Bar);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        int id = item.getItemId();

        if(id == R.id.action_page1){
            Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            finish();
        }

        else if(id == R.id.action_page2){
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
            finish();        }

        return true;
    }//

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);

        MenuInflater  inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item){

        if(item.getItemId()==R.id.action_option1){
            Toast.makeText(this, "you selected first item", Toast.LENGTH_SHORT).show();
            return true;
        }

        else if(item.getItemId()==R.id.action_option2){
            Toast.makeText(this, "you selected second item", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }


}
