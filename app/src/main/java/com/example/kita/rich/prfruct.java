package com.example.kita.rich;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class prfruct extends AppCompatActivity {

    static  {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }

     DatabaseHelper db;

    EditText e1,e2,e3,e4,e5,e6,e7;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prfruct);

        db = new DatabaseHelper(this);
        e1 =(EditText) findViewById(R.id.Name);
        e2 =(EditText) findViewById(R.id.password);
        e3 =(EditText) findViewById(R.id.spassword);
        e4 =(EditText) findViewById(R.id.vozrost);
        e5 =(EditText) findViewById(R.id.ves);
        e6 =(EditText) findViewById(R.id.rost);
        e7 =(EditText) findViewById(R.id.rez);
        b1 = (Button) findViewById(R.id.registr);
        b2 = (Button) findViewById(R.id.vhod);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (prfruct.this,prRiba.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString(); // Имя
                String s2 = e2.getText().toString(); // Пароль
                String s3 = e3.getText().toString(); //
                String s4 = e4.getText().toString();  // возроост
                String s5 = e5.getText().toString();    // Вес
                String s6 = e6.getText().toString();    // рост
                String s7 = e7.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")){
                    Toast.makeText(getApplicationContext(),"Заполните поля",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (s2.equals(s3)){
                        Boolean chkName = db.chkName(s1);
                        if (chkName == true){
                            Boolean insert = db.insert(s1,s2,s4,s5,s6,s7);
                            if (insert == true){
                                Toast.makeText(getApplicationContext(),"Регистрация прошла успешно",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Хорошее имя, но оно уже занято ",Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(),"пароли не совпадают ",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}
