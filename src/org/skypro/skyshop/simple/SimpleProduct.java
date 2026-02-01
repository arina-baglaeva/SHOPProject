package org.skypro.skyshop.simple;

import org.skypro.skyshop.product.Product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String nameOfProduct, int price) {
        super(nameOfProduct);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть строго больше 0! ");
        }
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
