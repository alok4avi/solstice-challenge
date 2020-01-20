package com.hackerrank.eshopping.product.dashboard.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class for resource Product
 *
 */
@Entity(name = "product")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3061358861038933340L;

	@Id
	private Long id;
	private String name;
	private String category;
	@JsonProperty("retail_price")
	private Double retailPrice;
	@JsonProperty("discounted_price")
	private Double discountedPrice;
	private Boolean availability;

	public Product() {
	}

	public Product(Long id, String name, String category, Double retailPrice, Double discountedPrice,
			Boolean availability) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.retailPrice = retailPrice;
		this.discountedPrice = discountedPrice;
		this.availability = availability;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	@JsonIgnore
	public int getDiscountPercentage() {
		int discountPercentage = (int) Math
				.round((((this.getRetailPrice() - this.getDiscountedPrice()) / this.getRetailPrice()) * 100.0));
		return discountPercentage;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", retailPrice=" + retailPrice
				+ ", discountedPrice=" + discountedPrice + ", availability=" + availability + "]";
	}
	

}
