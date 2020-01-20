package com.hackerrank.eshopping.product.dashboard.service;

import java.util.List;

import com.hackerrank.eshopping.product.dashboard.model.Product;

/**
 * Interface to perform various service operations depending upon the request 
 *
 */
public interface ProductsService {
	
	void addProduct(Product product);
	Product findProductById(Long id);
	List<Product> findProductByCategory(String category);
	List<Product> findProductByCategoryAndAvailibility(String category, Boolean availibility);
	List<Product> findAllProducts();
	void updateProductById(Product product);

}
