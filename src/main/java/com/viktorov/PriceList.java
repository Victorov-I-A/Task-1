package com.viktorov;

import java.util.ArrayList;

public class PriceList {
    private ArrayList<Product> list;


    public PriceList() {
        list = new ArrayList<Product>();
    }


    public void add(Product product, int kod) {
        for (Product element: list)
            if (kod == element.getKod()) {
                return;
            }
        product.setKod(kod);
        list.add(product);
    }

    public void del(int kod) {
        for (Product element : list)
            if (kod == element.getKod()) {
                list.remove(element);
                list.trimToSize();
                return;
            }
    }

    public Product getProduct(int kod) {
        for (Product element : list)
            if (kod == element.getKod())
                return element;
        throw new java.lang.NullPointerException();
    }

    public double getPrice(int kod, int number) {
        for (Product element : list)
            if (kod == element.getKod()) {
                return element.getPrice() * number;
            }
        throw new java.lang.NullPointerException();
    }
}