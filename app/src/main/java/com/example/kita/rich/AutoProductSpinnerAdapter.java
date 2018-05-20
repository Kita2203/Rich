package com.example.kita.rich;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AutoProductSpinnerAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<Product> productList;


    public AutoProductSpinnerAdapter(Context context, ArrayList<Product> productList)
    {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         View view = layoutInflater.inflate(R.layout.spinner_item,parent,false);
          Product product = (Product) getItem(position);
        TextView Name = (TextView) view.findViewById(R.id.Name);
        Name.setText(product.getProductName());


        ImageView Logo = (ImageView) view.findViewById(R.id.Logo);
        Logo.setImageResource(product.getProductLogo());

        return view;

    }
}
