package com.bedu.inventory.controllers;

import com.bedu.inventory.models.Product;
import com.bedu.inventory.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.save(product);
    }
}