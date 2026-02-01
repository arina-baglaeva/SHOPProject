package org.skypro.skyshop.discounted;

import org.skypro.skyshop.product.Product;

import java.util.Random;

public class DiscountedProduct extends Product {
    private int basicPrice;
    private int sale;
    private Random r = new Random();

    public DiscountedProduct(String nameOfProducts, int basicPrice) {
        super(nameOfProducts);

        int sale = r.nextInt(0, 100);
        if (basicPrice < 0 || sale < 0 || sale > 100) {
            throw new IllegalArgumentException("Базовая цена должна быть строго больше 0. Процент скидки должен быть числом в диапазоне от 0 до 100 включительно.");
        }
        this.basicPrice = basicPrice;
        this.sale = sale;
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
