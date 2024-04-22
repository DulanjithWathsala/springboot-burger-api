package edu.icet.demo.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private String productName;
    private String description;
    private String category;
    private Double price;
}
