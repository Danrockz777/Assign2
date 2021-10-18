package com.example.assign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Confirmation extends AppCompatActivity {

    //Notification variables
    private final String CHANNEL_ID= "testing notofication";
    private final int NOTIFICATION_ID= 001;
    //Generate Random String
    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null ) {
            String name = bundle.getString("Name");
            String address = bundle.getString("Address");
            String phone = bundle.getString("Phone");
            String note = bundle.getString("Note");
            String time = bundle.getString("Time");
            String date = bundle.getString("Date");
            TextView tvName = findViewById(R.id.tvName);
            TextView tvAddress = findViewById(R.id.tvAddress);
            TextView tvPhone= findViewById(R.id.tvPhone);
            TextView tvNote = findViewById(R.id.tvNote);
            TextView tvTime = findViewById(R.id.tvTime);
            TextView tvDate = findViewById(R.id.tvDate);
            tvName.setText("Name is :"+" " + name);
            tvAddress.setText("Address is :"+" " + address);
            tvPhone.setText("Phone number is :"+" " + phone);
            tvNote.setText("Note is :"+" " + note);
            tvTime.setText("Chosen time is :"+" " + time);
            tvDate.setText("Chosen date is :"+" " + date);

        }
        int n = 10;
        TextView tvString =findViewById(R.id.tvString);
        tvString.setText("Your Reservation ID is :"+" "+Confirmation.getAlphaNumericString(n));

        //Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(Confirmation.this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Reservation Status")
                .setContentText("Congrats ! Your Reservation has been confirmed !")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Congrats ! Your Reservation has been confirmed !"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
    }
    public void displayToast (String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

    public void goHome(View view) {
        Intent home= new Intent(Confirmation.this, sopscreen.class);
       startActivity(home);

    }



}