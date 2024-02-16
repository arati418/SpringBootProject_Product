package com.example.demo.serviceimpl;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;

import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getProduct(){
		return productRepository.findAll();
	}

	


	public Product getProductById(Integer pid) {
		// TODO Auto-generated method stub
		Optional<Product> product = productRepository.findById(pid);
		return product.orElse(null);
	}




	public Product postProduct(Product product) {
		// TODO Auto-generated method stub
		Product p=productRepository.save(product);
		return p;
	}




	public String deleteProductById(Integer pid) {
		// TODO Auto-generated method stub
		productRepository.deleteById(pid);
		return "Delete Success";
	}




	public String updateProductById(Integer pid, Product updatingProduct) {
		// TODO Auto-generated method stub
		Optional<Product>existingProduct=productRepository.findById(pid);
		if(existingProduct.isPresent()) {
			Product product=existingProduct.get();
			product.setPname(updatingProduct.getPname());
			productRepository.save(product);
			return "Update is Success";
		}
		else {
			return "Record Not Found";
		}
		
	}

	public Product getProductByName(String pname) {
		// TODO Auto-generated method stub
		Product product=productRepository.findByName(pname);		
		return product;
	}

}
