package com.product.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}
	public Product updateProduct(Product product) {
		Product exstProd =  productRepository.findById(product.getId()).get();
		exstProd.setId(product.getId());
		exstProd.setProdName(product.getProdName());
		Product updatedProduct =  productRepository.save(exstProd);
		return updatedProduct;
	}
}
