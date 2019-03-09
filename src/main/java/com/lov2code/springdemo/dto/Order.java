package com.lov2code.springdemo.dto;

public class Order {
	private Integer productId;
	private Integer quantity;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Order [productId=" + productId + ", quantity=" + quantity + "]";
	}
}
