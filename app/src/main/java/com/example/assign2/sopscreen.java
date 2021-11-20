package com.example.assign2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class sopscreen extends AppCompatActivity {
    //For strings array declaration for recycler view
    //Declare two string array
    String sName[], sDescription[];
    int images[] = {R.drawable.sanitizer, R.drawable.vaccine, R.drawable.facemask, R.drawable.keepdistance, R.drawable.table,R.drawable.mysej};

    //for the purpose of explicit intents
    public static final String EXTRA_MESSAGE =
            "com.example.droidcafe2.extra.MESSAGE";

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
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sopaudio);
        mediaPlayer.start();


    }
    //mymenu.xml for action bar display on SOP screen

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }*/

    //Display Toast Function for action Bar
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    //dialog alert whis called when customer chooses action order from SOP screen

    /*
    public void onAlert(View view) {
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(sopscreen.this);
        myAlertBuilder.setTitle(R.string.alert_title);
        myAlertBuilder.setMessage(R.string.alert_message);
        myAlertBuilder.setPositiveButton(R.string.ok_button, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked OK button.
                        Toast.makeText(getApplicationContext(), "Pressed OK",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        myAlertBuilder.setNegativeButton(R.string.cancel_button, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog.
                        Toast.makeText(getApplicationContext(), "Pressed Cancel",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        myAlertBuilder.show();
    }
*/


    //Get Action Bar Menu Option
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id =item.getItemId();
        switch(id){
            case R.id.action_order:
                displayToast(getString(R.string.action_order_message));
                /*
                Intent intent= new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE,mOrderMessage);
                startActivity(intent);
                Log.d("You chose this","Sucessfully Toasted !");
                return true;*/
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //Alert Dialog
                AlertDialog alertDialog = new AlertDialog.Builder(this)
                        //set icon
                        .setIcon(R.drawable.ic_dialog_warning)
                        //set title
                        .setTitle(R.string.alert_title)
                        //set message
                        .setMessage(R.string.alert_message)
                        //set positive button
                        .setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //set what would happen when positive button is clicked
                                displayToast("You may proceed to make a Reservation.");
                                //open quiz if fully vaccinated
                                Intent intent3 = new Intent(sopscreen.this, declareform.class);
                                startActivity(intent3);

                            }
                        })


                        //set negative button
                        .setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //set what should happen when negative button is clicked
                                displayToast("You are not allowed to make a Reservation !");
                                finish();
                            }
                        })
                        .show();
                /////////////////////////////////////////////////////////////////////////////////////////////
                return true;
            case R.id.action_status:
                Intent check = new Intent(sopscreen.this, Confirmation.class);
                startActivity(check);
                //navigateUpTo(getIntent());
                displayToast(getString(R.string.action_status_message));
                return  true;
            case R.id.action_enquire:
                displayToast(getString(R.string.action_enquire_message));
                Intent intent2 = new Intent(sopscreen.this, implicitintents.class);
                startActivity(intent2);

            default:
                // Do nothing


        }
        return super.onOptionsItemSelected(item);
    }



}