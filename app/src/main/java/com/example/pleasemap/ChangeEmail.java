package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeEmail extends AppCompatActivity {
    DatabaseHelper db;
    EditText txtCurrentUsername,txtNewUsername1,txtNewUsername2;
    Button btnChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_username);
        db = new DatabaseHelper (this);
        Bundle bundle = getIntent().getExtras();
        final String UserName = bundle.getString("UserName");

        txtCurrentUsername = (EditText) findViewById(R.id.txtCurrentUsername);
        txtNewUsername1 = (EditText) findViewById(R.id.txtNewUsername1);
        txtNewUsername2 = (EditText) findViewById(R.id.txtNewUsername2);

        btnChange = (Button) findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String CurrentUsername = txtCurrentUsername.getText().toString();
                String NewUsername1 = txtNewUsername1.getText().toString();
                String NewUsername2= txtNewUsername2.getText().toString();

                if(CurrentUsername.equals("")||NewUsername1.equals("")||NewUsername2.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (NewUsername1.equals(NewUsername1)) {
                        Boolean checkPassword = db.checkPassword(UserName, NewUsername1);
                        if(checkPassword) {
                            Boolean insert = db.updateUsername(UserName, CurrentUsername);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Username Changed", Toast.LENGTH_SHORT).show();
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
