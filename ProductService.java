package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;

@Service
public interface ProductService {
	public List<Product> getProduct();
     public Product getProductById(Integer pid);
     public Product postProduct(Product product);
     public String deleteProductById(Integer pid);
     public String updateProductById(Integer pid,Product updatingProduct);

}
