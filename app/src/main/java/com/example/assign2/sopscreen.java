package com.example.assign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class sopscreen extends AppCompatActivity {
    //For strings array declaration for recycler view
    //Declare two string array
    String sName[], sDescription[];
    int images[] = {R.drawable.sanitizer, R.drawable.vaccine, R.drawable.facemask, R.drawable.keepdistance, R.drawable.table,R.drawable.mysej};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sopscreen);
        //change lable for recycler sop
        setTitle("SOP's To Follow :" );
        //add Recycler View object
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //extract title and description from strings.xml
        sName = getResources().getStringArray(R.array.SOP);
        sDescription = getResources().getStringArray(R.array.description);
        //set adapter
        MyAdapter myAdapter=new MyAdapter(this,sName,sDescription,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}