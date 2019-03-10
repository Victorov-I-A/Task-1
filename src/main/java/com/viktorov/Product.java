package com.viktorov;

public class Product {
    private String name;
    private double price;
    private int kod;


    public Product(String name, int rubles, int penny) {
        this.name = name;
        this.price = rubles + penny / 100 + (double) (penny % 100) / 100;
    }


    public void setPrice(int rubles, int penny) {
        price = rubles + penny / 100 + (double) (penny % 100) / 100;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void setKod(int kod) {
        this.kod = kod;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    protected int getKod() {
        return kod;
    }
}