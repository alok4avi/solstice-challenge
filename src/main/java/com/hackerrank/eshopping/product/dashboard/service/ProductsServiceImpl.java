package com.hackerrank.eshopping.product.dashboard.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.repo.ProductsRepository;
/**
 * Service class to perform various service operations depending upon the request 
 *
 */
@Service
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	private ProductsRepository repository;
	
	Logger logger = Logger.getLogger(ProductsRepository.class);

	@Override
	public void addProduct(Product product) {
		try{
		repository.save(product);
		logger.debug("Product added!");
		}
		catch(Exception ex){
			logger.error("Exction occurred while saving the product with id : " + product.getId());
		}
	}

	@Override
	public Product findProductById(Long id) {
		return repository.findProductById(id);
	}

	@Override
	public void updateProductById(Product product) {
		try{
				repository.save(product);
				logger.debug("Product updated!");
			}
		catch(Exception ex){
			logger.error("Exction occurred while updating the product with id : " + product.getId());
		}
		
	}

	@Override
	public List<Product> findProductByCategory(String category) {
		return repository.findProductByCategory(category);
	}

	@Override
	public List<Product> findProductByCategoryAndAvailibility(String category, Boolean availability) {
		return repository.findProductByCategoryAndAvailability(category, availability);
	}

	@Override
	public List<Product> findAllProducts() {
		return repository.findAll();
	}
	
	
}
