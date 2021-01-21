package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyInfo extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);



    }
    public void ToChangeEmail(View view) {
        Intent intent = new Intent(this, ChangeEmail.class);
        //This will carry the users username from the login page to use when registering and deregistering cars
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
    public void ToChangePassword(View view) {
        Intent intent = new Intent(this, ChangePassword.class);
        //This will carry the users username from the login page to use when registering and deregistering cars
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
    public void ToViewMyCars(View view) {
        Intent intent = new Intent(this, ViewMyCars.class);
        //This will carry the users username from the login page to use when registering and deregistering cars
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
}
