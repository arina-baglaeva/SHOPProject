package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String nameOfProduct;

    public Product(String nameOfProduct) {

        this.nameOfProduct = nameOfProduct;
    }

    public abstract int getPrice();

    public String getNameOfProduct() {
        return nameOfProduct;
    }


    public int hashCode() {
        return Objects.hash(nameOfProduct);
    }

    public boolean isSpecial() {
        return false;
    }
    public String searchTerm(){
        return nameOfProduct;
    }

    public String getOfTypeContent(){
        return "PRODUCT";
    }

    public String getOfNameObject(){
        return nameOfProduct;
    }
}
