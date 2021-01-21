package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BuyTickets3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_tickets3);
    }
    public void BuyOne (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Lower Main Street Strabane";
        intent.putExtra("FocusAddress", FocusAddress);
        startActivity(intent);
    }
    public void ViewOne (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Lower Main Street Strabane";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Lower Main Street";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void BuyTwo (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Upper Main Street Strabane";
        intent.putExtra("FocusAddress", FocusAddress);
        startActivity(intent);
    }
    public void ViewTwo (View view){
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
    public void BuyThree (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Railway Street, Strabane";
        intent.putExtra("FocusAddress", FocusAddress);
        startActivity(intent);
    }
    public void ViewThree (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Railway Street, Strabane";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Railway Street";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void BuyFour (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Foyle Road BT48 6XB";
        intent.putExtra("FocusAddress", FocusAddress);
        startActivity(intent);
    }
    public void ViewFour (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Foyle Road BT48 6XB";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Foyle Road";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void BuyFive (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Foyle Valley Railway";
        intent.putExtra("FocusAddress", FocusAddress);
        startActivity(intent);
    }
    public void ViewFive (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Foyle Valley Railway";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Foyle Valley";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void NextPage(View view) {
        Intent intent = new Intent(this, BuyTickets4.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
    public void PrevPage(View view) {
        Intent intent = new Intent(this, BuyTickets2.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
}
