package com.example.assign2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    String title[],desciption[];
    int images[];

    public MyAdapter(Context context, String[] title, String[] desciption, int[] images) {
        this.context = context;
        this.title = title;
        this.desciption = desciption;
        this.images = images;
    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.my_row,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.txtTitle.setText(title[position]);
        holder.txtDesc.setText(desciption[position]);
        holder.imgLogo.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return  title.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtDesc;
        ImageView imgLogo;
        //constructor
        public MyViewHolder(View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.txtLanguage);
            txtDesc=itemView.findViewById(R.id.txtDesc);
            imgLogo =itemView.findViewById(R.id.imgLogo);
        }
    }
}
