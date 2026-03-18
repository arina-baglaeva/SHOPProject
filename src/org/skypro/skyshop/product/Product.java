package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String nameOfProduct;

    public Product(String nameOfProduct) {
        if (nameOfProduct.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой!");
        }
        this.nameOfProduct = nameOfProduct;

    }

    public abstract int getPrice();

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public boolean isSpecial() {
        return false;
    }

    public String searchTerm() {
        return nameOfProduct;
    }

    public String getOfTypeContent() {
        return "PRODUCT";
    }

    public String getName() {
        return nameOfProduct;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        return Objects.equals(nameOfProduct, other.nameOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfProduct);
    }
}
