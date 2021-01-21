package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CarInfo extends AppCompatActivity {
    DatabaseHelper db;

    EditText txtRegistration, txtMake, txtModel, txtColour, txtDeregister;
    Button btnRegisterCar, btnDeregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);
        //Commented out is part of transferring username from activity to activity but currently isn't implemented due to firebase
        Bundle bundle = getIntent().getExtras();
        final String UserName = bundle.getString("Username");
        db = new DatabaseHelper(this);

        txtRegistration = (EditText) findViewById(R.id.txtRegistration);
        txtMake = (EditText) findViewById(R.id.txtMake);
        txtModel = (EditText) findViewById(R.id.txtModel);
        txtColour = (EditText) findViewById(R.id.txtColour);
        txtDeregister = (EditText) findViewById(R.id.txtDeregister);
        btnRegisterCar = (Button) findViewById(R.id.btnRegisterCar);
        btnDeregister = (Button) findViewById(R.id.btnDeregister);

        btnRegisterCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Registration = txtRegistration.getText().toString();
                String Make = txtMake.getText().toString();
                String Model = txtModel.getText().toString();
                String Colour = txtColour.getText().toString();

                if (Registration.equals("") || Make.equals("") || Model.equals("") || Colour.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {

                    Boolean checkRegistration = db.checkRegistration(Registration);

                    if (checkRegistration == true) {

                        Boolean insert = db.insertCar(UserName, Registration, Make, Model, Colour);

                        if (insert == true) {
                            Toast.makeText(getApplicationContext(), "Register Successful", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Car already Exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnDeregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Deregister = txtDeregister.getText().toString();
                if (Deregister.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {

                    Boolean checkRegistration = db.checkRegistration(Deregister);

                    if (checkRegistration == false) {

                        Boolean delete = db.dropCar(Deregister);

                        if (delete == true) {
                            Toast.makeText(getApplicationContext(), "Car removed from owned cars", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

    public void ToCarParks(View view) {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
    public void Back(View view) {
        Intent intent = new Intent(this, MainScreen.class);
        Bundle bundle = getIntent().getExtras();
        String Username = bundle.getString("Username");
        intent.putExtra("Username", Username);
        startActivity(intent);
    }
}
