package org.example.democ0624;
public class Medicine {
    private int id;
    private String name;
    private String manufacturer;
    private double price;
    private int stock;

    public Medicine(int id, String name, String manufacturer, double price, int stock) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}