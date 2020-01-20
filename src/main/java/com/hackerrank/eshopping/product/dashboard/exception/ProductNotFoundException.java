package com.hackerrank.eshopping.product.dashboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1419226545790239909L;

	public ProductNotFoundException(String message) {
		super(message);
	}
	
	

}
