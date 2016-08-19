package com.niit.testbackend;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table


public class Supplier {
	private String id;
	private String suppliername;
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getsuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}


