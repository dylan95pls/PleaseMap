package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ViewMyCars extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_cars);
        db = new DatabaseHelper (this);

        TextView ticket1 = (TextView)findViewById(R.id.ticket1);
        TextView ticket2 = (TextView)findViewById(R.id.ticket2);
        TextView ticket3 = (TextView)findViewById(R.id.ticket3);
        TextView ticket4 = (TextView)findViewById(R.id.ticket4);
        TextView ticket5 = (TextView)findViewById(R.id.ticket5);

        Bundle bundle = getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        Cursor ShowTicket = db.ShowCar(UserName);
        String array[] = new String[ShowTicket.getCount()];
        int i = 0;
        ShowTicket.moveToFirst();
        while (!ShowTicket.isAfterLast()) {
            array[i] = ShowTicket.getString(0);
            i++;
            ShowTicket.moveToNext();
            Toast.makeText(getApplicationContext(), "Thats my funeral?", Toast.LENGTH_SHORT).show();
        }
        Boolean BlowFar = db.BlowFar("s");
        if(BlowFar){
            Toast.makeText(getApplicationContext(), "IUGFVEghogxfkill me", Toast.LENGTH_SHORT).show();
        } else{
        }

        //Toast.makeText(getApplicationContext(), array[0], Toast.LENGTH_SHORT).show();
       // ticket1.setText(array[0]);
        //setContentView(ticket1);
    }
}
