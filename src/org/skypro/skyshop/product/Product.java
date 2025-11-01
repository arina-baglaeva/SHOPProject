package org.skypro.skyshop.product;

public class Product {
    private String nameOfProduct;
    private int cost;

    public Product(String nameOfProduct, int cost) {
        this.nameOfProduct = nameOfProduct;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int new_cost) {
        this.cost = new_cost;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }
}
