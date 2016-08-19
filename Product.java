package com.niit.testbackend;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table
public class Product {
	private String id;
	private String productname;
	private int price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setproductname(String productname) {
		this.productname = productname;
	}
	
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}
	



}
