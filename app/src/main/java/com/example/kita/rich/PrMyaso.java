package com.example.kita.rich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PrMyaso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pr_myaso);
    }
    public void Nazad(View v) {
        Intent intObj = new Intent(this, Top.class);
        startActivity(intObj);
    }
}
