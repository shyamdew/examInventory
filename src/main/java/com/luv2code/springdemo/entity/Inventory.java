package com.luv2code.springdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Inventory")
public class Inventory   implements Serializable{
	@Id
	private Integer id;
	private String name;
	private BigDecimal price;
	@Column(name="CATAGORY_ID")
	private String catagoryId;
	@Column(name="QUNATITY")
	private Integer quantity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCatagotyId() {
		return catagoryId;
	}
	public void setCatagotyId(String catagotyId) {
		this.catagoryId = catagotyId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", price=" + price + ", catagotyId=" + catagoryId
				+ ", quantity=" + quantity + "]";
	}
	
}
