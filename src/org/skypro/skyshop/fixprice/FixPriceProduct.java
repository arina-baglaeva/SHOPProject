package org.skypro.skyshop.fixprice;

import org.skypro.skyshop.product.Product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 666;

    public FixPriceProduct(String nameOfProduct) {
        super(nameOfProduct);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public String toString() {
        return getNameOfProduct() + ": Фиксированная цена: " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
