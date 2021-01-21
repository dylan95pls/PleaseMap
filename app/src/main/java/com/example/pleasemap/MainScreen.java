package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pleasemap.MapsActivity;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }
    public void ToCarParks(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Society Street BT48 6PJ";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Society Street";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void ToInfoPage(View view) {
        Intent intent = new Intent(this, CarInfo.class);
        //This will carry the users username from the login page to use when registering and deregistering cars
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
    public void MyInfo (View view){
        Intent intent = new Intent(this, MyInfo.class);
        //This will carry the users username from the login page to use when registering and deregistering cars
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
    public void ToTickets (View view){
        Intent intent = new Intent(this, BuyTickets.class);
        //This will carry the users username from the login page to use when registering and deregistering cars
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }

}
