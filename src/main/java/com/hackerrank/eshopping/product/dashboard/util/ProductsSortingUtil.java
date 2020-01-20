package com.hackerrank.eshopping.product.dashboard.util;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;

import com.hackerrank.eshopping.product.dashboard.model.Product;

/**
 * Util class to have utility methods for sorting list of products 
 *
 */
public class ProductsSortingUtil {

	/**
	 * Method to sort the list of products by category
	 * 
	 * @param productList
	 * @return
	 */
	public static List<Product> sortProductsByCategory(List<Product> productList) {

		Collections.sort(productList,
				(o1, o2) -> new CompareToBuilder().append(o2.getAvailability(), o1.getAvailability())
						.append(o1.getDiscountedPrice(), o2.getDiscountedPrice()).toComparison());
		return productList;

	}

	/**
	 * Method to sort the list of products by category & availability
	 * 
	 * @param productList
	 * @return
	 */
	public static List<Product> sortProductsByCategoryAndAvailibility(List<Product> productList) {

		Collections.sort(productList,
				(o1, o2) -> new CompareToBuilder().append(o2.getDiscountPercentage(), o1.getDiscountPercentage())
						.append(o1.getDiscountedPrice(), o2.getDiscountedPrice()).append(o1.getId(), o2.getId())
						.toComparison());
		return productList;

	}

	/**
	 * Method sort the products by their Id
	 * 
	 * @param productList
	 * @return
	 */
	public static List<Product> sortProductsById(List<Product> productList) {

		Collections.sort(productList, (o1, o2) -> (o1.getId() > o2.getId() ? 
				1 : o1.getId() < o2.getId() ? -1 : 0));
		return productList;

	}

}
