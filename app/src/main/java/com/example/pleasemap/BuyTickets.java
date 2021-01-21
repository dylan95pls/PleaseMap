package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BuyTickets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_tickets);
    }
    public void BuyOne (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String Address = "Bishop Street BT48 6PR";
        intent.putExtra("Address", Address);
        startActivity(intent);
    }
    public void ViewOne (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Bishop Street BT48 6PR";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Bishop Street";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void BuyTwo (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String Address = "Carlisle Road BT48 6JW";
        intent.putExtra("Address", Address);
        startActivity(intent);
    }
    public void ViewTwo (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Carlisle Road BT48 6JW";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Carlisle Road";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void BuyThree (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String Address = "Foyle Street BT48 6AT";
        intent.putExtra("Address", Address);
        startActivity(intent);
    }
    public void ViewThree (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Foyle Street BT48 6AT";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Foyle Street";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void BuyFour (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String Address = "Society Street BT48 6PJ";
        intent.putExtra("Address", Address);
        startActivity(intent);
    }
    public void ViewFour (View view){
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
    public void BuyFive (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String Address = "Victoria Market Derry/Londonderry";
        intent.putExtra("Address", Address);
        startActivity(intent);
    }
    public void ViewFive (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Victoria Market Derry/Londonderry";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Victoria Market";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void NextPage(View view) {
        Intent intent = new Intent(this, BuyTickets2.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
    public void PrevPage(View view) {
        Intent intent = new Intent(this, BuyTickets.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
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
