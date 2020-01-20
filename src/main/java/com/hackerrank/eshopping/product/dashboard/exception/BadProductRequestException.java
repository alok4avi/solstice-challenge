package com.hackerrank.eshopping.product.dashboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadProductRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9136984616340376330L;

	public BadProductRequestException(String message) {
		super(message);
	}
}
