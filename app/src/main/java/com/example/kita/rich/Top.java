package com.example.kita.rich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Top extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
    }
    public void newScreen(View v) {
        Intent intObj = new Intent(this, Rich1.class);
        startActivity(intObj);
    }
    public void Myaso (View v) {
        Intent intObj = new Intent(this, PrMyaso.class);
        startActivity(intObj);
    }

    public void Fruct (View v) {
        Intent intObj = new Intent(this, prfruct.class);
        startActivity(intObj);
    }
    public void Riba (View v) {
        Intent intObj = new Intent(this, prRiba.class);
        startActivity(intObj);
    }
    public void Bluda (View v) {
        Intent intObj = new Intent(this, prBluda.class);
        startActivity(intObj);
    }

}
