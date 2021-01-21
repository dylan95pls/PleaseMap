package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BuyTickets4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_tickets4);
    }
    public void ViewOne (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Market Square Claudy";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Market Square";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void ViewTwo (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Meetinghouse Lane Castlederg";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Meetinghouse Lane";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void ViewThree (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "William Street Castlederg";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "William Street";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void ViewFour (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Priest’s Lane Castlederg";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Priest's Lane";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void ViewFive (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Albert Street Castlederg";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Albert Street";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void NextPage(View view) {
        Intent intent = new Intent(this, BuyTickets5.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
    public void PrevPage(View view) {
        Intent intent = new Intent(this, BuyTickets3.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
}
