package com.bedu.inventory.services;

import com.bedu.inventory.models.Product;
import com.bedu.inventory.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }
}