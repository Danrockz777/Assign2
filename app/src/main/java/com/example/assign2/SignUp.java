package com.example.assign2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    DatabaseHelper dbHelper;
    EditText username,password,cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        dbHelper=new DatabaseHelper(this);
        username=findViewById(R.id.etUserID);
        password=findViewById(R.id.etPWSignUp);
        cpassword=findViewById(R.id.etConfirmPW);
    }

    public void displayToast(String message){
        Toast.makeText(this , message, Toast.LENGTH_SHORT).show();
    }


    public void SignUp(View view) {
        String user=username.getText().toString();
        String pw=password.getText().toString();
        String cpw=cpassword.getText().toString();

        if(user.equals("")|| pw.equals("")||cpw.equals(""))
            displayToast("Fields Required !");
        else{
            if(pw.equals(cpw)){
                boolean taken = dbHelper.checkUsername(user);
                if(!taken){
                    boolean insertSuccessfully = dbHelper.insert(user,pw);
                    if(insertSuccessfully){
                        displayToast("Registered Successfully !");
                        username.setText("");
                        password.setText("");
                        cpassword.setText("");
                    }
                }
                else{
                    username.setError("User name has been taken !");
                }
            }
            else
                cpassword.setError("Confirm password mismatched !");
        }

    }

    public void Login(View view) {
        Intent intent=new Intent(this,LoginPage.class);
        startActivity(intent);
    }
}