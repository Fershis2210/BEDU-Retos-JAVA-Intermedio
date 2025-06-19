package com.bedu.inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trademark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    protected Trademark(){}

    public Trademark(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}
