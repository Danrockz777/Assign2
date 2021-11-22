package com.example.assign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ShareCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //First screen Greeting to get idd
        ConstraintLayout layout = findViewById(R.id.bg);
        TextView textview = findViewById(R.id.tv);
        //get time from calendar
        Calendar calendar = Calendar.getInstance();
        int Hours = calendar.get(Calendar.HOUR_OF_DAY);
        //Morning
        if (Hours > 0 && Hours < 12) {
            textview.setText("Good Morning Friend !");
            layout.setBackgroundResource(R.drawable.gm);
        }//afternoon
        else if (Hours >= 12 && Hours < 15) {
            textview.setText("Good Afternoon !");
            layout.setBackgroundResource(R.drawable.ga);
        }//evening
        else if (Hours >= 15 && Hours < 19) {
            textview.setText("Have a Lovely Evening !");
            layout.setBackgroundResource(R.drawable.ge);
        }//night
        else {
            textview.setText("Have a Great Night!");
            layout.setBackgroundResource(R.drawable.gn);
        }
        //set timer for first screen before sopscreen
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //explicit intent to change screen
                Intent intent1 = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent1);
                //close first activity
                finish();
            }
        }, 3000);// 3 seconds timer

    }

}