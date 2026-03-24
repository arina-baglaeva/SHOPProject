package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.discounted.DiscountedProduct;
import org.skypro.skyshop.fixprice.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.BestResultNotFound;
import org.skypro.skyshop.searchable.Searchable;
import org.skypro.skyshop.simple.SimpleProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.searchable.SearchEngine;

import java.util.*;

public class App {
    public static void main(String[] args) {
        SearchEngine arr = new SearchEngine();
        try {
            SimpleProduct pr1 = new SimpleProduct("Сыр", 209);
            FixPriceProduct pr2 = new FixPriceProduct("Колбаса");
            FixPriceProduct pr3 = new FixPriceProduct("Вино");
            DiscountedProduct pr4 = new DiscountedProduct("Пуддинг", 140);
            DiscountedProduct pr5 = new DiscountedProduct("Хлеб", 78);
            SimpleProduct pr6 = new SimpleProduct("ТОРТ", 700);
            ProductBasket basket = new ProductBasket();
            basket.add(pr1);
            basket.add(pr2);
            basket.add(pr3);
            basket.add(pr4);
            basket.add(pr5);
            basket.add(pr6);
            basket.whatContainBasket();
            System.out.println("Стоимость корзины: " + basket.returnCount());
            System.out.println("Поиск " + pr5.getNameOfProduct() + ": " + basket.findProduct(pr5.getNameOfProduct()));
            System.out.println("Поиск " + pr6.getNameOfProduct() + ": " + basket.findProduct(pr6.getNameOfProduct()));
            String prodDel = "Пуддинг";
            System.out.println("Список удаленных продуктов по названию '" + prodDel + "' :");
            List<Product> del = basket.deleteProduct(prodDel);
            for (Product p : del) {
                System.out.println(p);
            }
            basket.printBasket();
            Iterator<Product> iterator = del.iterator();
            System.out.println("Очищаем список удаленных продуктов. ");
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
            if (del.isEmpty())
                System.out.println("Список пуст.");
            System.out.println("Очистка корзины: ");
            basket.cleanBasket();
            basket.whatContainBasket();
            System.out.println("Стоимость корзины: " + basket.returnCount());
            System.out.println("Поиск " + pr1.getNameOfProduct() + ": " + basket.findProduct(pr1.getNameOfProduct()));

        } catch (IllegalArgumentException ex) {
            System.err.println("Ошибка в создании продукта, некорректные данные: " + ex.getMessage());
        } finally {
            System.out.println("Проверка IllegalArgumentException завершена.");
        }
        Article art1 = new Article("Сыр: Искусство вкуса и традиций", "Сыр — это не просто молочный продукт, это целая культура, насчитывающая тысячелетия истории. Наш сыр создается по традиционным рецептам из отборного молока, с соблюдением всех технологических процессов. Каждая головка сыра вызревает не менее 60 дней, что придает ему неповторимый насыщенный вкус и аромат.");
        Article art2 = new Article("Колбаса: Наслаждение классикой", "Наша колбаса — это возвращение к истокам качества. Изготовленная из отборной говядины и свинины с добавлением натуральных специй, она сохраняет все лучшие традиции мясного производства. Нежная текстура, насыщенный мясной вкус и аппетитный аромат делают эту колбасу идеальным выбором для завтраков, бутербродов или как компонент для салатов.");
        Article art3 = new Article("Вино: Элегантность в каждом глотке", "Это вино — настоящая поэзия в бокале. Созданное из винограда, собранного на солнечных склонах, оно сочетает в себе богатый букет ароматов и сбалансированный вкус. Каждая бутылка — результат кропотливого труда виноделов, которые сохраняют уникальный характер терруара.");
        Article art4 = new Article("Пудинг: Нежность в каждой ложке", "Наш пудинг — это облако нежности, которое тает во рту. Приготовленный по особой рецептуре с использованием натуральных ингредиентов, он обладает нежной кремовой текстурой и приятным ванильным ароматом. Это идеальный десерт для тех, кто ценит изысканность без излишней сладости. Благодаря специальной технологии приготовления пудинг сохраняет свою воздушную структуру и свежесть.");
        Article art5 = new Article("Хлеб: Традиция в каждой крошке", "Наш хлеб выпекается по старинным рецептам с использованием натуральной закваски. Хрустящая корочка золотистого цвета и пористый, ароматный мякиш — вот отличительные черты этого традиционного хлеба. Мы используем только качественную муку и соблюдаем все этапы правильного брожения теста. Очень вкусно его кушать на завтрак с сыром и колбасой и запивая вином.");
        arr.add(art1);
        arr.add(art2);
        arr.add(art3);
        arr.add(art4);
        arr.add(art5);
        System.out.println("'Сыр': ");
        Set<Searchable> found = arr.search("Сыр");
        printArr(found);
        System.out.println("'Вино': ");
        Set<Searchable> f2 = arr.search("Вино");
        printArr(f2);
        System.out.println("'Хлеб': ");
        Set<Searchable> f3 = arr.search("Хлеб");
        printArr(f3);
        System.out.println("'Традиц': ");
        Set<Searchable> f4 = arr.search("Традиц");
        printArr(f4);
        try {
            Searchable t = arr.findBestMatch("сыр");
            System.out.println("Подходящий объект: " + t);
        } catch (BestResultNotFound e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("проверка BestResultNotFound успех завершена");
        }
        try {
            Searchable t = arr.findBestMatch("бубубу");
            System.out.println("Подходящий объект: " + t);
        } catch (BestResultNotFound e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("проверка BestResultNotFound провал завершена");
        }
    }

    public static void printArr(Set<Searchable> res) {
        boolean f = false;
        int c = 0;
        for (Searchable i : res) {
            if (i != null) {
                System.out.println((c + 1) + ". " + i.getStringRepresentation());
                f = true;
            }
        }
        if (!f)
            System.out.println("Ничего не найдено!");

    }
}