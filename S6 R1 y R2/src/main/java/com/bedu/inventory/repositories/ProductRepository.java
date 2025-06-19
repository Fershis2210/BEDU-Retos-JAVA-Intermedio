package com.bedu.inventory.repositories;

import com.bedu.inventory.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByPriceBetween(double min, double max);
    List<Product> findByNameStartingWithIgnoreCase(String prefix);
    List<Product> findByNameContaining(String name);
}