package com.example.assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class progressbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar3);
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(progressbar.this,sopscreen.class));
            }
        };
        Timer opening=new Timer();
        opening.schedule(task,5000);
    }
}