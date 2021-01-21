package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;

    EditText txtUsername, txtPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnRegister = (Button) findViewById(R.id.btnLogin);
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String Username = txtUsername.getText().toString();
                String Password = txtPassword.getText().toString();

                if (Username.equals("") || Password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    Boolean checkPassword = db.checkPassword(Username, Password);
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    if (checkPassword == true) {
                        Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(), MainScreen.class);
                        String UserName = txtUsername.getText().toString();
                        intent.putExtra("UserName", UserName);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
    public void sendHome(View view) {
        Intent intent = new Intent(this, MainScreen.class);
        String UserName = "2";
        intent.putExtra("UserName", UserName);
        startActivity(intent);
    }
    public void ToTickets (View view){
        Boolean PurchaseTicket = db.binsert("1stnndfg", "adyahrol", "iusrgivusbudvub");
        if (PurchaseTicket) {
            Toast.makeText(getApplicationContext(), "Ticket Purchased", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Hurt me daddy", Toast.LENGTH_SHORT).show();
        }
    }
}
