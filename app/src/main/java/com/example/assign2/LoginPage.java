package com.example.assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    DatabaseHelper dbHelper;
    EditText username,password;
    Button Login, SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        dbHelper=new DatabaseHelper(this);
        username=findViewById(R.id.etID);
        password=findViewById(R.id.etPassword);

        Login=findViewById(R.id.btnLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pw=password.getText().toString();
                if(username.getText().toString().equals("admin123") && password.getText().toString().equals("admin123")){
                    Intent intent=new Intent(getApplicationContext(),EmployeeMain.class);
                    startActivity(intent);
                }

                boolean loginSuccessful = dbHelper.checkLogin(user,pw);
                if(loginSuccessful){
                    displayToast("Login Sucessful");

                    Intent intent=new Intent(getApplicationContext(),sopscreen.class);
                    startActivity(intent);
                }else{
                    if(username.getText().toString().equals("admin123") && password.getText().toString().equals("admin123")){
                    displayToast("Admin Login");
                    }
                    else {
                    displayToast("Invalid Credentials");
                    username.setText("");
                    password.setText("");}
                }
            }
        });

        SignUp =findViewById(R.id.btnSignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });

    }

    public void displayToast(String message){
        Toast.makeText(this , message, Toast.LENGTH_SHORT).show();
    }
}