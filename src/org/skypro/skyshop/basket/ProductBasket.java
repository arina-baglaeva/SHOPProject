package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> basket;

    public ProductBasket() {
        basket = new HashMap<>();
    }

    public long returnCount() {
        long total = basket.values().
                stream().flatMap(Collection::stream).
                mapToInt(Product::getPrice).sum();
        return total;
    }

    public void add(Product pr) {
        basket.computeIfAbsent(pr.getNameOfProduct(), k -> new ArrayList<>()).add(pr);
        System.out.println("Добавлен продукт: " + pr.getNameOfProduct());
    }


    public void whatContainBasket() {
        long sum = returnCount();
        if (sum == 0) {
            System.out.println("В корзине пусто!");
        } else {
            basket.values().stream().flatMap(Collection::stream).
                    forEach(System.out::println);
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + getSpecialCount());
        }
    }

    private long getSpecialCount() {
        long specialGoods = basket.values().stream().flatMap(Collection::stream).
                filter(Product::isSpecial).count();
        return specialGoods;
    }

    public boolean findProduct(String name) {
        return basket.values().stream().flatMap(Collection::stream).
                anyMatch(pr -> pr.getNameOfProduct().equals(name));
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
        basket.values().stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
