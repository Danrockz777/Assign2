package com.example.assign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class viewReservation extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{

    private boolean isCheckedValue;
    private  String Name2;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reservation);




        setTitle("Customer Reservation Details ");
        Intent intent = getIntent();
        /*
        String message = "Order: " +
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);*/
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }


    }

    public void onRadioButtonClicked (View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:

                if (checked)
                    // Same day service
                    displayToast(getString(R.string.same_day_messenger_service));

                break;
            case R.id.nextday:
                if (checked)

                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));


                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up));

                break;
            default:


                break;

        }

        /*
        if (checked==false){
            displayToast("Make sure at least one Radio Button is checked !");
            Intent intent6 = new Intent(viewReservation.this, viewReservation.class);
            startActivity(intent6);
        }*/

    }



    public void displayToast (String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String spinnerLabel = adapterView.getItemAtPosition(position).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string +
                "/" + year_string);

        EditText dateEt=findViewById(R.id.date_text);
        dateEt.setText(dateMessage);

        Toast.makeText(this, getString(R.string.date) + dateMessage,
                Toast.LENGTH_SHORT).show();
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        // Convert time elements into strings.
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        // Assign the concatenated strings to timeMessage.
        String timeMessage = (hour_string + ":" + minute_string);

        EditText TimeEt=findViewById(R.id.time_text);
        TimeEt.setText(timeMessage);

        Toast.makeText(this,getString(R.string.time_toast)
                + timeMessage, Toast.LENGTH_SHORT).show();
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.datepicker));
    }

    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.timepicker));
    }


    public void upload(View view) {

        //Make sure checkbox is checked
        //initiate a check box

        CheckBox simpleCheckBox = (CheckBox) findViewById(R.id.checkBox);

       /*RadioButton selectedRadioButton1 = (RadioButton)findViewById(R.id.sameday);
        selectedRadioButton1.setChecked(true);*/
        RadioButton radiobutton1 =(RadioButton)findViewById(R.id.sameday);
        radiobutton1.setChecked(true);

        //RadioButton selectedRadioButton2 = (RadioButton)findViewById(R.id.nextday);
        //selectedRadioButton2.setChecked(true);

        //RadioButton selectedRadioButton3 = (RadioButton)findViewById(R.id.pickup);
        //selectedRadioButton3.setChecked(true);



        /*
                displayToast(getString(R.string.same_day_messenger_service));*/

        //displayToast(getString(R.string.same_day_messenger_service));
        //RadioGroup mySelection = (RadioGroup)findViewById(R.id.radioGroup);
        //int radioButtonId = mySelection.getCheckedRadioButtonId();
        EditText textname, textaddress, textphone, textnote, textdate, texttime;
        textname=findViewById(R.id.name_text);
        textaddress=findViewById(R.id.address_text);
        textphone=findViewById(R.id.phone_text);
        textnote=findViewById(R.id.note_text);
        textdate=findViewById(R.id.date_text);
        texttime=findViewById(R.id.time_text);
        String name = textname.getText().toString().trim();
        String address = textaddress.getText().toString().trim();
        String phone= textphone.getText().toString().trim();
        String note = textnote.getText().toString().trim();
        String date = textdate.getText().toString().trim();
        String time = texttime.getText().toString().trim();

        //check current state of a check box (true or false)
        if(simpleCheckBox.isChecked() && radiobutton1.isChecked()  ){
            //start confirmation activity


            /*
            //Basic edittext validation to make sure all fields are filled
            String checkname=textname.getText().toString();
            String checkaddress=textaddress.getText().toString();
            String checknphone=textphone.getText().toString();
            String checknote=textnote.getText().toString();
            String checkdate=textdate.getText().toString();
            String checktime=texttime.getText().toString();*/

            ///////////////////////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////////////////




            Bundle bundle = new Bundle();
            bundle.putString("Name", name);
            bundle.putString("Address", address);
            bundle.putString("Phone", phone);
            bundle.putString("Note", note);
            bundle.putString("Date",date);
            bundle.putString("Time", time);
            Intent intent = new Intent(viewReservation.this, Confirmation.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }else{

            if(name.equals("")|| address.equals("")||phone.equals("")||note.equals("")||date.equals("")||time.equals("")) {
                textname.setError("Username is required !");
                textaddress.setError("Addressis required !");
                textphone.setError("Phone is required !");
                textnote.setError("Note is required !");
                textdate.setError("Date is required !");
                texttime.setError("Time is required !");


            }

            displayToast("Make sure checkbox and Radio Button is checked !");
            /*Intent intent6 = new Intent(viewReservation.this, viewReservation.class);
            startActivity(intent6);*/


        }

        /*
        //explicit intent to confirmation activity
        EditText textname, textaddress, textphone, textnote, textdate, texttime;
        textname=findViewById(R.id.name_text);
        textaddress=findViewById(R.id.address_text);
        textphone=findViewById(R.id.phone_text);
        textnote=findViewById(R.id.note_text);
        textdate=findViewById(R.id.date_text);
        texttime=findViewById(R.id.time_text);

        String name = textname.getText().toString().trim();
        String address = textaddress.getText().toString().trim();
        String phone= textphone.getText().toString().trim();
        String note = textnote.getText().toString().trim();
        String date = textdate.getText().toString().trim();
        String time = texttime.getText().toString().trim();

        Bundle bundle = new Bundle();
        bundle.putString("Name", name);
        bundle.putString("Address", address);
        bundle.putString("Phone", phone);
        bundle.putString("Note", note);
        bundle.putString("Date",date);
        bundle.putString("Time", time);
        Intent intent = new Intent(viewReservation.this, Confirmation.class);
        intent.putExtras(bundle);
        startActivity(intent);*/










    }
}