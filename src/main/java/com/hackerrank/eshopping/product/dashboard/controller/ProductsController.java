package com.hackerrank.eshopping.product.dashboard.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

import com.hackerrank.eshopping.product.dashboard.exception.BadProductRequestException;
import com.hackerrank.eshopping.product.dashboard.exception.ProductNotFoundException;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.model.ProductUpdateRequestDTO;
import com.hackerrank.eshopping.product.dashboard.service.ProductsService;
import com.hackerrank.eshopping.product.dashboard.util.ProductsSortingUtil;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

	@Autowired
	private ProductsService service;

	@ApiOperation(value = "Add a new product", notes = "Add a new product")
	@PostMapping
	public ResponseEntity<Object> addProduct(@RequestBody Product product) {
		if (service.findProductById(product.getId()) != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} else {
			service.addProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}

	}

	@ApiOperation(value = "Update a existing product", notes = "Update the product properties using id")
	@PutMapping("/{product_id}")
	public ResponseEntity<Object> updateProductById(@RequestBody ProductUpdateRequestDTO updatedProduct,
			@PathVariable Long product_id) {

		Product product = service.findProductById(product_id);
		if (product != null) {
			product.setRetailPrice(updatedProduct.getRetailPrice());
			product.setDiscountedPrice(updatedProduct.getDiscountedPrice());
			product.setAvailability(updatedProduct.getAvailability());
			product.setId(product_id);
			service.updateProductById(product);
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			throw new BadProductRequestException("Product requested to update not found!");
		}
	}

	@ApiOperation(value = "Find product by id", notes = "Return the unique product by using id")
	@GetMapping("/{product_id}")
	public Product findProductById(@PathVariable Long product_id) {
		Product requestedProduct = service.findProductById(product_id);
		if (requestedProduct == null) {
			throw new ProductNotFoundException("Product requested not found!");
		} else {
			return requestedProduct;
		}

	}

	@ApiOperation(value = "Find list of products", notes = "Depending upon the request parameter retrieve the list of products")
	@GetMapping
	public List<Product> findProducts(@RequestParam(value = "category", required = false) String categoryParam,
			@RequestParam(value = "availability", required = false) Integer availParam) {
		List<Product> productList = null;

		String category = categoryParam != null ? UriUtils.decode(categoryParam, "UTF-8") : null;

		if (categoryParam == null && availParam == null) {
			productList = service.findAllProducts();
			ProductsSortingUtil.sortProductsById(productList);

		} else if (availParam != null) {
			boolean availability = availParam.equals(Integer.valueOf(1)) ? true : false;
			productList = service.findProductByCategoryAndAvailibility(category, availability);
			ProductsSortingUtil.sortProductsByCategoryAndAvailibility(productList);
		} else {
			productList = service.findProductByCategory(category);
			ProductsSortingUtil.sortProductsByCategory(productList);
		}

		if (productList == null) {
			throw new ProductNotFoundException("Products requested not found!");
		} else {
			return productList;
		}

	}

}
