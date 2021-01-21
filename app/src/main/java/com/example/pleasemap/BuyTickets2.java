package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BuyTickets2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_tickets2);
    }
    public void BuyOne (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Queens Quay BT 48 7AS";
        intent.putExtra("FocusAddress", FocusAddress);
        startActivity(intent);
    }
    public void ViewOne (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Queens Quay BT 48 7AS";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Queens Quay";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void BuyTwo (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Spencer Road";
        intent.putExtra("FocusAddress", FocusAddress);
        startActivity(intent);
    }
    public void ViewTwo (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Spencer Road";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Spencer Road";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void BuyThree (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Strand Road BT487AL";
        intent.putExtra("FocusAddress", FocusAddress);
        startActivity(intent);
    }
    public void ViewThree (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Strand Road BT487AL";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Strand Road";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void BuyFour (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "William Street Derry/Londonderry";
        intent.putExtra("FocusAddress", FocusAddress);
        startActivity(intent);
    }
    public void ViewFour (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "William Street Derry/Londonderry";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "William Street";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void BuyFive (View view){
        //Purchase ticket in slot one
        Intent intent = new Intent(this, PurchaseTicket.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Butcher Street Strabane";
        intent.putExtra("FocusAddress", FocusAddress);
        startActivity(intent);
    }
    public void ViewFive (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        String FocusAddress = "Butcher Street Strabane";
        intent.putExtra("FocusAddress", FocusAddress);
        String FocusName = "Butcher Street";
        intent.putExtra("FocusName", FocusName);
        startActivity(intent);
    }
    public void NextPage(View view) {
        Intent intent = new Intent(this, BuyTickets3.class);
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
}
