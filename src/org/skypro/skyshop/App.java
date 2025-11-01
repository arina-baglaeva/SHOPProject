package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product pr1 = new Product("Сыр", 209);
        Product pr2 = new Product("Колбаса", 467);
        Product pr3 = new Product("Вино", 798);
        Product pr4 = new Product("пудинг", 140);
        Product pr5 = new Product("Хлеб", 50);
        Product pr6 = new Product("ТОРТ", 700);
        ProductBasket basket = new ProductBasket();
        basket.AddToBasket(pr1);
        basket.AddToBasket(pr2);
        basket.AddToBasket(pr3);
        basket.AddToBasket(pr4);
        basket.AddToBasket(pr5);
        basket.AddToBasket(pr6);
        basket.WhatContainBasket();
        System.out.println("Стоимость корзины: " + basket.ReturnCount());
        System.out.println("Поиск "+pr5.getNameOfProduct()+": "+basket.FindProduct(pr5.getNameOfProduct()));
        System.out.println("Поиск "+pr6.getNameOfProduct()+": "+basket.FindProduct(pr6.getNameOfProduct()));
        System.out.println("Очистка корзины: ");
        basket.CleanBasket();
        basket.WhatContainBasket();
        System.out.println("Стоимость корзины: " + basket.ReturnCount());
        System.out.println("Поиск "+pr1.getNameOfProduct()+": "+basket.FindProduct(pr1.getNameOfProduct()));

    }
}