package com.bedu.inventory;

import com.bedu.inventory.models.Category;
import com.bedu.inventory.models.Product;
import com.bedu.inventory.models.Trademark;
import com.bedu.inventory.repositories.CategoryRepository;
import com.bedu.inventory.repositories.ProductRepository;
import com.bedu.inventory.repositories.TrademarkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductRepository productRepo, CategoryRepository categoryRepo, TrademarkRepository trademarkRepo) {
		return args -> {
			Category technology = new Category("Technology");
			categoryRepo.save(technology);

			Trademark lenovo = new Trademark("Lenovo");
			trademarkRepo.save(lenovo);

			Trademark samsung = new Trademark("Samsung");
			trademarkRepo.save(samsung);

			Trademark logitech = new Trademark("Logitech");
			trademarkRepo.save(logitech);

			Trademark lg = new Trademark("LG");
			trademarkRepo.save(lg);

			productRepo.save(new Product("Laptop Lenovo", "AMD Ryzen 7, 16GB RAM", 18500.0, technology, lenovo));
			productRepo.save(new Product("Wireless Mouse", "Logitech, optic sensor", 450.0, technology, logitech));
			productRepo.save(new Product("Monitor LG", "27 inches, Full HD", 4300.0, technology, lg));
			productRepo.save(new Product("Smartphone Samsung Galaxy S21", "128GB, 8GB RAM", 15000.0, technology, samsung));
			productRepo.save(new Product("Samsung TUGFA:3000", "128GB, 8GB RAM", 15000.0, technology, samsung));

			System.out.println("📦 Products created:");
			productRepo.findAll().forEach(System.out::println);

			// Print products with price greater than 500
			System.out.println("\n📊 Products with price greater than 500:");
			productRepo.findByPriceGreaterThan(500.0).forEach(System.out::println);

			// Print products containing "lap" in their name (case insensitive)
			System.out.println("\n🔍 Products containing \"lap\" in their name:");
			productRepo.findByNameContainingIgnoreCase("lap").forEach(System.out::println);

			// Print products with price between 400 and 1000
			System.out.println("\n💰 Products with price between 400 and 1000:");
			productRepo.findByPriceBetween(400.0, 1000.0).forEach(System.out::println);

			// Print products whose name starts with "m" or "M"
			System.out.println("\n🔤 Products whose name starts with \"M\":");
			productRepo.findByNameStartingWithIgnoreCase("m").forEach(System.out::println);

			System.out.println("📚 Products by trademark:");
			trademarkRepo.findAll().forEach(trademark -> {
				System.out.println("🏷️ " + trademark.getName() + ":");
				productRepo.findAll().stream()
						.filter(p -> p.getTrademark().getId().equals(trademark.getId()))
						.forEach(p -> System.out.println("   - " + p.getName()));
			});
		};
	}

//  Example 1 - 2
//	@Bean
//	public CommandLineRunner demo(ProductRepository productRepo, CategoryRepository categoryRepo) {
//		return (args) -> {
//			Category technology = new Category("Technology");
//			categoryRepo.save(technology);
//
//			productRepo.save(new Product("Laptop ASUS ROG Strix SCAR 18", "Intel Core i9, RTX 5090", 90000.00, technology));
//			productRepo.save(new Product("Laptop MSI Titan 18 HX", "Intel Core i9, RTX 4090", 140000.00, technology));
//			productRepo.save(new Product("Tablet Lenovo", "Screen 10 inches", 7800.00, technology));
//
//			System.out.println("📂 Registered Products:");
//			productRepo.findAll().forEach(p -> System.out.println(p.getName() + " - " + p.getCategory().getName()));
//		};
//	}
}