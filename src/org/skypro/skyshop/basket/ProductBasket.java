package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] basket;

    public ProductBasket() {
        basket = new Product[5];
    }

    public void AddToBasket(Product pr) {
        boolean f = false;
        for(int i=0; i<5;i++){
            if (basket[i] == null) {
                basket[i] = pr;
                f = true;
                break;
            }
        }
        if (!f) {
            System.out.println("Невозможно добавить продукт");
        }

    }

    public int ReturnCount() {
        int c = 0;
        for (int i = 0; i < 5; i++) {
            if (basket[i] != null) {
                c += basket[i].getCost();
            }
        }
        return c;
    }

    public void WhatContainBasket() {
        int sum = ReturnCount();
        if (sum == 0) {
            System.out.println("В корзине пусто!");
        } else {
            for (int i = 0; i < 5; i++) {
                if(basket[i]!=null)
                    System.out.println(basket[i].getNameOfProduct() + ":" + basket[i].getCost());
            }
            System.out.println("Итого: " + sum);
        }
    }

    public boolean FindProduct(String name) {

        for (int i = 0; i < 5; i++) {
            if (basket[i] != null && basket[i].getNameOfProduct().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void CleanBasket() {
        for (int i = 0; i < 5; i++) {
            basket[i] = null;
        }
    }
}
