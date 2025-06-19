package com.bedu.inventory.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    private String description;
    @Min(1)
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "trademark_id")
    private Trademark trademark;

    protected Product() {}

    public Product(String name, String description, double price, Category category, Trademark tradeMark) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.trademark = tradeMark;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public Category getCategory() { return category; }
    public Trademark getTrademark() { return trademark; }

    @Override
    public String toString() {
        return String.format("Product[id=%d, name='%s', price=%.2f, category='%s']",
                id, name, price, category != null ? category.getName() : "No category");
    }
}