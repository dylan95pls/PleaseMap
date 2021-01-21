package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PurchaseTicket extends AppCompatActivity {
    DatabaseHelper db;
    Button btnWorking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_purchase);
    }

    public void ToTickets(View view) {
        Toast.makeText(getApplicationContext(), "Ticket Purchased", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainScreen.class);
        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }

}
