package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private Map<String, List<Product>> basket;

    public ProductBasket() {
        basket = new HashMap<>();
    }

    public int returnCount() {
        int c = 0;
        for (Map.Entry<String, List<Product>> product : basket.entrySet()) {
            for (Product pr : product.getValue()) {
                c += pr.getPrice();

            }
        }
        return c;
    }

    public void add(Product pr) {
        basket.computeIfAbsent(pr.getNameOfProduct(), k -> new ArrayList<>()).add(pr);
        System.out.println("Добавлен продукт: " + pr.getNameOfProduct());
    }


    public void whatContainBasket() {
        int sum = returnCount();
        int specialGoods = 0;
        if (sum == 0) {
            System.out.println("В корзине пусто!");
        } else {
            for (Map.Entry<String, List<Product>> product : basket.entrySet()) {
                for (Product pr : product.getValue()) {
                    System.out.println(pr);
                    if (pr.isSpecial())
                        specialGoods++;
                }
            }
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + specialGoods);
        }
    }

    public boolean findProduct(String name) {
        for (Map.Entry<String, List<Product>> product : basket.entrySet()) {
            for (Product pr : product.getValue()) {
                if (pr.getNameOfProduct().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Product> deleteProduct(String name) {
        List<Product> delPr = basket.remove(name);
        return delPr != null ? delPr : new ArrayList<>();
    }

    public void cleanBasket() {
        basket.clear();
    }

    public void printBasket() {
        System.out.println("Теперь в корзине находятся: ");
        for (Map.Entry<String, List<Product>> product : basket.entrySet()) {
            for (Product pr : product.getValue()) {
                System.out.println(pr);
            }
        }
    }
}
