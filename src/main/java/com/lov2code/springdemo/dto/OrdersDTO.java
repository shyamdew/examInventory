package com.lov2code.springdemo.dto;

import java.util.List;

public class OrdersDTO extends RequestDTO {
	private List<Order> orders;
	private Integer orderId;
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "OrdersDTO [orders=" + orders + ", orderId=" + orderId + "]";
	}
	
}
