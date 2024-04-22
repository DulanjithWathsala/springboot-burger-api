package edu.icet.demo.service;

import edu.icet.demo.model.Product;

import java.util.List;

public interface ProductService {

    public void saveProduct(Product product);

    public List<Product> getAllProducts();

    public List<Product> getProductsByCategory(String category);
}
