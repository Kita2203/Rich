package com.example.kita.rich;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class prRiba extends AppCompatActivity {

    static  {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }



        EditText e1,e2;
        Button b1,b2;
        DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pr_riba);


        db = new DatabaseHelper(this);
            e1 = (EditText)findViewById(R.id.login);
            e2 = (EditText)findViewById(R.id.password1);
            b1 = (Button)findViewById(R.id.vhod);
        b2 = (Button)findViewById(R.id.reg);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (prRiba.this,prfruct.class);
                startActivity(i);
            }
        });

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Name = e1.getText().toString();
                    String password = e2.getText().toString();
                    Boolean chkNamePass = db.Namepassword(Name, password);
                    if (chkNamePass == true) {
                        Toast.makeText(getApplicationContext(), "Добро пожаловать ", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(prRiba.this, prBluda.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "Имя или пароль не верны", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }

}
