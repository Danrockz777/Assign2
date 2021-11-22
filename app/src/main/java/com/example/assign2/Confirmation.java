package com.example.assign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Confirmation extends AppCompatActivity {

    //Notification variables
    private final String CHANNEL_ID= "testing notofication";
    private final int NOTIFICATION_ID= 001;
    private Button addBookingsBtn, readBookingsBtn;
    private DBHandler dbHandler;
    private TextView tvName, tvAddress, tvNote, tvPhone, tvDate, tvTime, tvDelivery, tvString;

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
            String delivery=bundle.getString("Delivery");
            TextView tvName = findViewById(R.id.tvName);
            TextView tvAddress = findViewById(R.id.tvAddress);
            TextView tvPhone= findViewById(R.id.tvPhone);
            TextView tvNote = findViewById(R.id.tvNote);
            TextView tvTime = findViewById(R.id.tvTime);
            TextView tvDate = findViewById(R.id.tvDate);
            TextView tvDelivery=findViewById(R.id.tvDelivery);
            tvName.setText("Name is :"+" " + name);
            tvAddress.setText("Address is :"+" " + address);
            tvPhone.setText("Phone number is :"+" " + phone);
            tvNote.setText("Note is :"+" " + note);
            tvTime.setText("Chosen time is :"+" " + time);
            tvDate.setText("Chosen date is :"+" " + date);
            tvDelivery.setText("Delivery method :"+" "+delivery);
            int n = 10;
            TextView tvString =findViewById(R.id.tvString);
            tvString.setText("Your Reservation ID is :"+" "+Confirmation.getAlphaNumericString(n));

            //////////////////////////////////////////////////////////////////////////////////////////////////////
            /////////////////Add to DATABASE//////////////////////////////////////////////////////////////////////

            addBookingsBtn = findViewById(R.id.idBtnAddBookings);
            readBookingsBtn = findViewById(R.id.idBtnReadBookings);
            // creating a new dbhandler class
            // and passing our context to it.
            dbHandler = new DBHandler(Confirmation.this);

            // below line is to add on click listener for our add course button.
            addBookingsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // below line is to get data from all  fields.
                    String Name = tvName.getText().toString();
                    String Address = tvAddress.getText().toString();
                    String Phone = tvPhone.getText().toString();
                    String Note = tvNote.getText().toString();
                    String Date = tvDate.getText().toString();
                    String Time = tvTime.getText().toString();
                    String Delivery = tvDelivery.getText().toString();
                    String String2=  tvString.getText().toString();

                    // validating if the text fields are empty or not.
                    if (tvName.getText().toString().equals("") && tvAddress.getText().toString().equals("") && tvPhone.getText().toString().equals("")
                            && tvNote.getText().toString().equals("") && tvDate.getText().toString().equals("")&& tvTime.getText().toString().equals("") &&
                            tvDelivery.getText().toString().equals("")) {
                        Toast.makeText(Confirmation.this, "Reservation Booking has been made !..", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // on below line we are calling a method to add new
                    // course to sqlite data and pass all our values to it.
                    dbHandler.addNewBookings(Name, Address, Phone, Note
                            ,Date, Time, Delivery, String2);

                    // after adding the data we are displaying a toast message.
                    Toast.makeText(Confirmation.this, "Bookings has been added.", Toast.LENGTH_SHORT).show();
                    tvName.setText("");
                    tvAddress.setText("");
                    tvPhone.setText("");
                    tvNote.setText("");
                    tvDate.setText("");
                    tvTime.setText("");
                    tvDelivery.setText("");
                    tvString.setText("");
                }
            });



            readBookingsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // opening a new activity via a intent.
                    Intent i = new Intent(Confirmation.this, ViewBookings.class);
                    startActivity(i);
                }
            });

            /////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
        }


        //Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(Confirmation.this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Reservation Status")
                .setContentText("Congrats ! Your Almost There !")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Please Confirm to make your Reservation !"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());


    }
    public void displayToast (String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

    public void goHome(View view) {
        Intent home= new Intent(Confirmation.this, progressbar.class);
       startActivity(home);

    }





}