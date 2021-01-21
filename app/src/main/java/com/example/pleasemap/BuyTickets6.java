package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BuyTickets6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_tickets6);
    }
    public void ViewOne (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Upper Main Street Strabane";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Upper Main Street";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void ViewTwo (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Bowling Green Strabane";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Bowling Green";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void ViewThree (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Mill Street Strabane";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Mill Street";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void ViewFour (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Canal Basin North Strabane";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Canal Basin North";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void ViewFive (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Canal Basin (Dock Street)Strabane";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Canal Basin (Dock Street)";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void NextPage(View view) {
        Intent intent = new Intent(this, BuyTickets6.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
    public void PrevPage(View view) {
        Intent intent = new Intent(this, BuyTickets5.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
}
