package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {
    private String nameOfProduct;

    public Product(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public abstract int getPrice();

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public int hashCode() {
        return Objects.hash(nameOfProduct);
    }

    public abstract String toString();

    public boolean isSpecial() {
        return false;
    }
}
