package com.luv2code.springdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_DETAILS")
public class OrdersDetail   implements Serializable{
	@Id
	@Column(name="order_id")
	private Integer orderId;
	@Id
	@Column(name="product_id")
	private Integer productId;
	private Integer quantity;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
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
		return "OrdersDetail [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
}
