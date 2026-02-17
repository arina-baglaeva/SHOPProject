package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private List<Product> basket;

    public ProductBasket() {
        basket = new LinkedList<>();
    }

    public int returnCount() {
        int c = 0;
        for (Product product : basket) {
            if (product != null) {
                c += product.getPrice();
            }
        }
        return c;
    }

    public void add(Product pr) {
        basket.add(pr);
        System.out.println("Добавлен продукт: " + pr.getNameOfProduct());
    }


    public void whatContainBasket() {
        int sum = returnCount();
        int specialGoods = 0;
        if (sum == 0) {
            System.out.println("В корзине пусто!");
        } else {
            for (Product product : basket) {
                if (product != null) {
                    System.out.println(product);
                    if (product.isSpecial())
                        specialGoods++;
                }
            }
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + specialGoods);
        }
    }

    public boolean findProduct(String name) {

        for (Product product : basket) {
            if (product != null && product.getNameOfProduct().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Product> deleteProduct(String name) {
        List<Product> delPr = new ArrayList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (Objects.equals(product.getNameOfProduct().toLowerCase(), name.toLowerCase())) {
                delPr.add(product);
                iterator.remove();
            }
        }
        return delPr;

    }

    public void cleanBasket() {
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    public void printBasket() {
        System.out.println("Теперь в корзине находятся: ");
        for (Product pr : basket) {
            System.out.println(pr);
        }
    }
}
