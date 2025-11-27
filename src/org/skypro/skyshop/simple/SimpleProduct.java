package org.skypro.skyshop.simple;

import org.skypro.skyshop.product.Product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String nameOfProduct, int price) {
        super(nameOfProduct);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getNameOfProduct() + ":" + getPrice();
    }
}
