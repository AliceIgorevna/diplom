package com.epam.demennikova.fashion.dao;

import java.util.List;

import com.epam.demennikova.fashion.entity.Product;


public interface ProductDao {
	
	public void addProduct(String productName, String productDesc);
	
	public void deleteProduct(String productName);
	
	public void updateProduct(String productName, String productDesc, int idProduct);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(int idProduct);
}
