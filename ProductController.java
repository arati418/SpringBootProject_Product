package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.serviceimpl.ProductServiceImpl;

@RestController
public class ProductController {
	@Autowired
	ProductServiceImpl productService;
	
	//Get list of Product
	
	@GetMapping(value="/get")
	public List<Product> getProduct(){
		return productService.getProduct();
	}
	
	//Get product by id
	@GetMapping(value="/getid/{pid}")
	public Product getProductById(@PathVariable Integer pid) {
		return productService.getProductById(pid);
	}
	
	//Get product by name
	@GetMapping(value="/getname/{pname}")
	public Product getProductByName(@PathVariable String pname) {
		return productService.getProductByName(pname);
	}
	
	//insert product into db
	@PostMapping(value="/post")
	public Product postProduct(@RequestBody Product product) {
		return productService.postProduct(product);
	}
	//delete product by id
	@DeleteMapping(value="/delete/{pid}")
	public String deleteProductById(@PathVariable Integer pid) {
		return productService.deleteProductById(pid);
	}
	//update product by id
	@PutMapping(value="/put/{pid}")
	public String updateProductById(@PathVariable Integer pid,@RequestBody Product product) {
		return productService.updateProductById(pid,product);
	}

}
