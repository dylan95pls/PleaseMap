package com.example.pleasemap;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    DatabaseHelper db;

    EditText txtUsername, txtPassword, txtPassword2, txtFirstName, txtSurname;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper (this);

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtPassword2 = (EditText) findViewById(R.id.txtPassword2);
        txtFirstName = (EditText) findViewById(R.id.txtFirstName);
        txtSurname= (EditText) findViewById(R.id.txtSurname);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String Username = txtUsername.getText().toString();
                String Password = txtPassword.getText().toString();
                String Password2 = txtPassword2.getText().toString();
                String FName = txtFirstName.getText().toString();
                String SName = txtSurname.getText().toString();

                if(Username.equals("")||Password.equals("")||Password2.equals("")|| FName.equals("")||SName.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else{

                    Boolean checkUsername = db.checkUsername(Username);
                    if(checkUsername==true){
                         if (Password.equals(Password2)) {

                             Boolean insert = db.insert(Username, FName, SName, Password);

                             if (insert == true) {
                                 Toast.makeText(getApplicationContext(), "Register Successful", Toast.LENGTH_SHORT).show();
                                 Intent intent = new Intent(view.getContext(), MainActivity.class);
                                 startActivity(intent);
                             }
                         }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Username already Exists",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void Back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}