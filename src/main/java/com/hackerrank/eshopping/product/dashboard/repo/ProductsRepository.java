package com.hackerrank.eshopping.product.dashboard.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.eshopping.product.dashboard.model.Product;

/**
 * Repository layer to retrieve Products
 *
 */
public interface ProductsRepository extends JpaRepository<Product, Long> {

	Product findProductById(Long id);
	List<Product> findProductByCategory(String category);
	List<Product> findProductByCategoryAndAvailability(String category, Boolean availability);
}
