package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entities.Product;
import com.learning.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductCrontroller {
	
	@Autowired
	ProductService service;
	
	@PostMapping()
	public Product createProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@GetMapping
	public List<Product> getProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") Long id) {
		return service.getProduct(id);
	}
	
	@PutMapping ("/{id}")
	public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		return service.updateProduct(id, product);
	}
	
	@DeleteMapping ("/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		return service.deleteProduct(id);
	}

}
