package com.example.kita.rich;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class Rich1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<Product> productList = new ArrayList<>();

    Button button;
    TextView textView;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rich1);
        textView = (TextView) findViewById(R.id.textView4);
        textView1 = (TextView) findViewById(R.id.textView6);
        textView2 = (TextView) findViewById(R.id.textView7);
        textView3 = (TextView) findViewById(R.id.textView8);
        button = (Button) findViewById(R.id.b_read);


        productList.add(new Product("Продукты", R.drawable.product,0,0,0,0));
        productList.add(new Product("Яблоко", R.drawable.yabloko,48,1,0,11));
        productList.add(new Product("Апельсин", R.drawable.apel, 38,1,0,9));
        productList.add(new Product("Грейпфрукт", R.drawable.greuy, 37,1,0,11));
        productList.add(new Product("Мандарин", R.drawable.mandar, 39,1,0,9));
        productList.add(new Product("Баранина ", R.drawable.baran, 201,16,15,0));
        productList.add(new Product("Говядина ", R.drawable.govyadina, 191,18,12,0));
        productList.add(new Product("Конина ", R.drawable.konina, 149,20,7,0));
        productList.add(new Product("Кролик ", R.drawable.krolic, 197,20,12,0));
        productList.add(new Product("Свинина ", R.drawable.cvenina, 318,16,28,0));
        productList.add(new Product("Курица ", R.drawable.kurica, 161,24,8,1));
        productList.add(new Product("Утка ", R.drawable.utca, 348,17,61,0));
        productList.add(new Product("Морковь ", R.drawable.morcov, 29,1,0,6));
        productList.add(new Product("Картофель ", R.drawable.kartofel, 198,3,10,24));
        productList.add(new Product("Горошик ", R.drawable.garoh, 75,5,0,13));
        productList.add(new Product("Кабачки ", R.drawable.kabacgki, 30,1,0,6));
        productList.add(new Product("Лук зеленый ", R.drawable.luk, 21,1,0,4));
        productList.add(new Product("Томаты ", R.drawable.tomati, 19,1,0,4));
        productList.add(new Product("Оливки ", R.drawable.olivki, 111,1,10,7));
        productList.add(new Product("Сахар ", R.drawable.sahar, 377,0,0,100));
        productList.add(new Product("Мед ", R.drawable.med, 312,1,0,80));
        productList.add(new Product("Печенье ", R.drawable.pechenie, 447,10,5,76));

        Spinner spproduct = (Spinner) findViewById(R.id.spproduct);

        AutoProductSpinnerAdapter spinnerAdapter = new AutoProductSpinnerAdapter(this, productList);
        spproduct.setAdapter(spinnerAdapter);
        spproduct.setOnItemSelectedListener(this);
    }

    public void NewDrace(View v) {
        Intent Intent = new Intent(this, Drace.class);
        startActivity(Intent);
    }
    public void NewTop(View v) {
        Intent Intent = new Intent(this, Top.class);
        startActivity(Intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        textView.setText("Калории яблока = 156");
        textView.setText("Калории = " + String.valueOf(productList.get(position).calories()));
        textView1.setText("Белки = " + String.valueOf(productList.get(position).bilki()));
        textView2.setText("Жиры = "  + String.valueOf(productList.get(position).jiri()));
        textView3.setText("Углеводы = "+ String.valueOf(productList.get(position).ygle()) );

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
