package org.skypro.skyshop.discounted;

import org.skypro.skyshop.product.Product;

import java.util.Random;

public class DiscountedProduct extends Product {
    private int basicPrice;
    private int sale;
    private Random r = new Random();

    public DiscountedProduct(String nameOfProducts, int basicPrice) {
        super(nameOfProducts);
        this.basicPrice = basicPrice;
        this.sale = r.nextInt(0, 100);
    }

    @Override
    public int getPrice() {
        return basicPrice - (basicPrice * sale / 100);
    }

    @Override
    public String toString() {
        return getNameOfProduct() + ":" + getPrice() + " (" + sale + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
