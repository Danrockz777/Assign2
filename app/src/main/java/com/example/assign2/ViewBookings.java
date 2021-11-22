package com.example.assign2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewBookings extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<BookingModal> BookingModalArrayList;
    private DBHandler dbHandler;
    private BookingsRVAdapter bookingsRVAdapter;
    private RecyclerView bookingsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bookings);

        // initializing our all variables.
        BookingModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewBookings.this);

        // getting our course array
        // list from db handler class.
        BookingModalArrayList = dbHandler.readBookings();

        // on below line passing our array lost to our adapter class.
        bookingsRVAdapter = new BookingsRVAdapter(BookingModalArrayList, ViewBookings.this);
        bookingsRV = findViewById(R.id.idRVBookings);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewBookings.this,
                RecyclerView.VERTICAL, false);
        bookingsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        bookingsRV.setAdapter(bookingsRVAdapter);
    }
}
