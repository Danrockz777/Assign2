package com.example.assign2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookingsRVAdapter extends RecyclerView.Adapter<BookingsRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<BookingModal> BookingModalArrayList;
    private Context context;

    // constructor
    public BookingsRVAdapter(ArrayList<BookingModal> BookingModalArrayList, Context context) {
        this.BookingModalArrayList= BookingModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookings_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        BookingModal modal = BookingModalArrayList.get(position);
        holder.Name.setText(modal.getName());
        holder.Address.setText(modal.getAddress());
        holder.Phone.setText(modal.getPhone());
        holder.Date.setText(modal.getDate());
        holder.Time.setText(modal.getTime());
        holder.String2.setText(modal.getString2());
        holder.Delivery.setText(modal.getDelivery());
        holder.Note.setText(modal.getNote());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return BookingModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView Name, Address, Note, Phone,Delivery, Date, Time, String2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            Name = itemView.findViewById(R.id.tvName);
            Address= itemView.findViewById(R.id.tvAddress);
            Note = itemView.findViewById(R.id.tvNote);
            Phone = itemView.findViewById(R.id.tvPhone);
           Delivery = itemView.findViewById(R.id.tvDelivery);
            Date = itemView.findViewById(R.id.tvDate);
            Time = itemView.findViewById(R.id.tvTime);
           String2 = itemView.findViewById(R.id.tvString);
        }
    }
}
