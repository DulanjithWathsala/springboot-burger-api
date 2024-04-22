package edu.icet.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.entity.ProductEntity;
import edu.icet.demo.model.Product;
import edu.icet.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    ObjectMapper mapper;

    public void saveProduct(Product product) {
        ProductEntity productEntity = mapper.convertValue(product, ProductEntity.class);
        repository.save(productEntity);
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();

        Iterable<ProductEntity> entities = repository.findAll();

        entities.forEach(productEntity -> {
            Product product = mapper.convertValue(productEntity, Product.class);
            productList.add(product);
        });

        return productList;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> productList = new ArrayList<>();

        Iterable<ProductEntity> entities = repository.findAllByCategory(category);

        entities.forEach(productEntity -> {
            Product product = mapper.convertValue(productEntity, Product.class);
            productList.add(product);
        });

        return productList;
    }
}
