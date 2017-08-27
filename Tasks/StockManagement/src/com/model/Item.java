package com.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity(name = "Item")
@Table(name = "ITEM")
@NamedNativeQuery(name = "item.getByItemId",query = "Select * from item where id = ?", resultClass=Item.class)
public class Item {
	@Id
	private Integer id;
	private String name;
	private Integer qunatity;
	private Double price;
	@Column(name = "man_date")
	private String manufacturingDate;
	
	public Item() {
		super();
	}
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
	public Integer getQunatity() {
		return qunatity;
	}
	public void setQunatity(Integer qunatity) {
		this.qunatity = qunatity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", qunatity=" + qunatity + ", price=" + price
				+ ", manufacturingDate=" + manufacturingDate + "]";
	}
	
	
}
