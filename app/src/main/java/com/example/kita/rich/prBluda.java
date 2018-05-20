package com.example.kita.rich;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class prBluda extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    static  {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }


    ArrayList<Product> productList = new ArrayList<>();

    TextView textView4;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView editText3;
    TextView textView5;
    public TextView theData;
    public Button Calendar;
    Button button;
    Button button7;
    database bd1;
    double a;
    double b;
    double c; ////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pr_bluda);
        theData = (TextView) findViewById(R.id.Data); // Лейбл показывающий дату
        Calendar = (Button) findViewById(R.id.Calendar); // кнопка  перехода в календарь
        database db1 = new database(this);
        textView4 = (TextView) findViewById(R.id.textView4); // калории
        textView6 = (TextView) findViewById(R.id.textView6);// белки
        textView7 = (TextView) findViewById(R.id.textView7); // жиры
        textView8 = (TextView) findViewById(R.id.textView8); // углеводы
        editText3 = (TextView) findViewById(R.id.editText3); //Ves
        textView5 = (TextView)findViewById(R.id.textView5); // otchet
        button7 = (Button)findViewById(R.id.button7);


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

//////////////////////////////////////////////////// календарь
        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        theData.setText(date);

        Calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(prBluda.this, CalendarActivity.class);
                startActivity(intent);

            }

        });
/////////////////////////////////////////////////////// календарь /

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        textView4.setText (  String.valueOf(productList.get(position).calories()));
        textView6.setText ("Белки = " + String.valueOf(productList.get(position).bilki()));
        textView7.setText ("Жиры = "  + String.valueOf(productList.get(position).jiri()));
        textView8.setText ("Углеводы = "+ String.valueOf(productList.get(position).ygle()) );

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void NewDrace(View v) {
        Intent Intent = new Intent(this, Drace.class);
        startActivity(Intent);
    }
    public void ClickButton(View v){

        String S1 = (String) textView4.getText();
        String S2 = editText3.getText().toString();
        a = Double.parseDouble(S1);
        b = Double.parseDouble(S2);
        c = b + a;
        String S = Double.toString(c);
        textView5.setText(S);}
}

