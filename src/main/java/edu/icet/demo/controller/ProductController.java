package edu.icet.demo.controller;

import edu.icet.demo.model.Product;
import edu.icet.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;
    @PostMapping("/product")
    void saveProduct(@RequestBody Product product) {
        service.saveProduct(product);
    }

    @GetMapping("/all-products")
    List<Product> getProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/products-by-category/{category}")
    List<Product> getProductsByCategory(@PathVariable String category) {
        return service.getProductsByCategory(category);
    }
}
