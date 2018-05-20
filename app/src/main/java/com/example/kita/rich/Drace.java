package com.example.kita.rich;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Drace extends AppCompatActivity {

    static  {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }

 private ImageView img;
 private Button rez;
 private int voidv;
 private static final  int DO = 1700;
 private static final  int DO2 = 2334;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drace);
        Vezual();
    }
    public void newScreen(View v) {
        Intent intObj = new Intent(this, prBluda.class);
        startActivity(intObj);
    }
    private void Vezual() {
        img = (ImageView)findViewById(R.id.imageView3);
        rez = (Button)findViewById(R.id.button14);
        voidv = Integer.parseInt(((EditText)findViewById(R.id.editText2)).getText().toString());


        rez.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        voidv = Integer.parseInt(((EditText)findViewById(R.id.editText2)).getText().toString());

                        if (voidv <= DO)
                            img.setImageResource(R.drawable.thin);
                        else if (voidv <= DO2)
                            img.setImageResource(R.drawable.medium);
                        else
                            img.setImageResource(R.drawable.fead);
                    }
                }
        );
    }
}
