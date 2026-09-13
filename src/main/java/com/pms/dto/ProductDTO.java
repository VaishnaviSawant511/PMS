package com.pms.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable
{
	private int pid;
	private String pname;
	private float cost;
	private String category;
	private String supplier;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
	
	public ProductDTO() {}
	
	
	public ProductDTO(int pid, String pname, float cost, String category, String supplier) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
		this.category = category;
		this.supplier = supplier;
	}
	
	

}
