package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {
    DatabaseHelper db;
    EditText txtUsername,txtPassword,txtPassword3;
    Button btnChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
        db = new DatabaseHelper(this);
        Bundle bundle = getIntent().getExtras();
        final String UserName = bundle.getString("UserName");

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtPassword3 = (EditText) findViewById(R.id.txtPassword3);

        btnChange = (Button) findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = txtUsername.getText().toString();
                String Password = txtPassword.getText().toString();
                String Password3 = txtPassword3.getText().toString();

                if (Username.equals("") || Password.equals("") || Password3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (Password.equals(Password3)) {
                        Boolean checkPassword = db.checkPassword(UserName, Username);
                        if (checkPassword) {
                            Boolean insert = db.updateUsername(UserName, Password);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Password Changed", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(view.getContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        });
    }
}
