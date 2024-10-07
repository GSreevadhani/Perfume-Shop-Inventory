package com.sreeperfumeshop;

public class PerfumeShop {
	private String name;
	private String prod_tag;
	private double price;
	private String essence;
	private String id;
	
	
	public PerfumeShop() {
		
	}

	public PerfumeShop(String name, String prod_tag, double price, String essence) {
		super();
		this.name = name;
		this.prod_tag = prod_tag;
		this.price = price;
		this.essence = essence;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProd_tag() {
		return prod_tag;
	}

	public void setProd_tag(String prod_tag) {
		this.prod_tag = prod_tag;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getEssence() {
		return essence;
	}

	public void setEssence(String essence) {
		this.essence = essence;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "PerfumeShop [name=" + name + ", prod_tag=" + prod_tag + ", price=" + price + ", essence=" + essence
				+ ", id=" + id + "]";
	}

}
