package com.project.model;

public class Wishlist {
	
	private int id, customerId, productId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Wishlist [id=" + id + ", customerId=" + customerId + ", productId=" + productId + "]";
	}

	

}