package com.example.kita.rich;

public class Product {


    private String productName;
    private int productLogo;
    private int calories;
    private int bilki;
    private int jiri;
    private int ygle;

     public  Product (String productName, int productLogo, int calories, int bilki,int jiri, int ygle)
    {
        this.productLogo = productLogo;
        this.productName = productName;
        this.calories = calories;
        this.bilki = bilki;
        this.jiri   =jiri;
        this.ygle = ygle;

    }

    public String getProductName() {
        return productName;
    }

    public int getProductLogo()
    {
        return productLogo;
    }

    public int calories()  { return calories; }

     public int bilki()  { return bilki; }

    public int jiri()  { return jiri; }

    public int ygle()  { return ygle; }

}
