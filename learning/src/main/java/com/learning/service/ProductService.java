package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entities.Product;
import com.learning.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product); // INSERT INTO PRODUCT ...
	}
	
	public List<Product> getProducts(){
		return repository.findAll(); // SELECT * FROM PRODUCT ...
	}
	
	public Product getProduct (Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("No se encontro"));
				
	}
	
	public Product updateProduct(Long id, Product newProduct) {
		Product productToBeUpdated = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("No se encontro"));
		productToBeUpdated.setName(newProduct.getName());
		productToBeUpdated.setType(newProduct.getType());
		productToBeUpdated.setPrice(newProduct.getPrice());
		return repository.save(productToBeUpdated);
	}
	
	public String deleteProduct(Long id) {
		repository.deleteById(id);
		return "Producto eliminado con exito";
	}

}
