package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.discounted.DiscountedProduct;
import org.skypro.skyshop.fixprice.FixPriceProduct;
import org.skypro.skyshop.simple.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct pr1 = new SimpleProduct("Сыр", 209);
        FixPriceProduct pr2 = new FixPriceProduct("Колбаса");
        FixPriceProduct pr3 = new FixPriceProduct("Вино");
        DiscountedProduct pr4 = new DiscountedProduct("пудинг", 140);
        DiscountedProduct pr5 = new DiscountedProduct("Хлеб", 78);
        SimpleProduct pr6 = new SimpleProduct("ТОРТ", 700);
        ProductBasket basket = new ProductBasket();
        basket.AddToBasket(pr1);
        basket.AddToBasket(pr2);
        basket.AddToBasket(pr3);
        basket.AddToBasket(pr4);
        basket.AddToBasket(pr5);
        basket.AddToBasket(pr6);
        basket.WhatContainBasket();
        System.out.println("Стоимость корзины: " + basket.ReturnCount());
        System.out.println("Поиск " + pr5.getNameOfProduct() + ": " + basket.FindProduct(pr5.getNameOfProduct()));
        System.out.println("Поиск " + pr6.getNameOfProduct() + ": " + basket.FindProduct(pr6.getNameOfProduct()));
        System.out.println("Очистка корзины: ");
        basket.CleanBasket();
        basket.WhatContainBasket();
        System.out.println("Стоимость корзины: " + basket.ReturnCount());
        System.out.println("Поиск " + pr1.getNameOfProduct() + ": " + basket.FindProduct(pr1.getNameOfProduct()));

    }
}