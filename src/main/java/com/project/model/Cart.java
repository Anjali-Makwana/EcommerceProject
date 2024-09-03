package com.project.model;

public class Cart {

	private int id;
	private int productId;
	private int customerId;
	
	private int qty;
	/*private int pprice;
	private int qty;
	private int total_amount;
	private String pname;

	private String pcategory;
	private String pdesc;
	private String image;
	private String payment_status;*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
}