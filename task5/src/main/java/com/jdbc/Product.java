package com.jdbc;

public class Product {
    private int id;
    private int prodid;
    private String title;
    private long cost;

    public Product(int id, int prodid, String title, long cost) {
        this.id = id;
        this.prodid = prodid;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public int getProdid() {
        return prodid;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "id: " + id + ", prodid: " + prodid + ", title: " + title + ", cost: " + cost;
    }
}
