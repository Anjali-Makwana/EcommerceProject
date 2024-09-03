package com.project.model;

public class Product {

	private int id;
	private int sellerId;
	private double productPrice;
	private String product_name;
	private String product_image;
	private String product_category;
	private String product_description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", sellerId=" + sellerId + ", productPrice=" + productPrice + ", product_name="
				+ product_name + ", product_image=" + product_image + ", product_category=" + product_category
				+ ", product_description=" + product_description + "]";
	}

}