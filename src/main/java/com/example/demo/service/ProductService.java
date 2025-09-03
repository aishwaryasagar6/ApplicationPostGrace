package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.db1.model.Product;
import com.example.demo.db1.repository.ProductRepo;

//Service class for product-related operations
@Service
public class ProductService {
	
	 @Autowired
	    private ProductRepo productRepo;

	    // Method to save a product
	    public Product saveProduct(Product product) {
	        return productRepo.save(product);
	    }

}
