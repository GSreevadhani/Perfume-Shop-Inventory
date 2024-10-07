package com.login;

public class PerfumeShop {
    private String prod_id;
    private String name;
    private String essence;
    private double price;

    // Getters and setters for fields
    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEssence() {
        return essence;
    }

    public void setEssence(String essence) {
        this.essence = essence;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
	public String toString() {
		return "Product ID=" + prod_id + ", Name=" + name + ", Essence=" + essence + ", Price=" + price;
	}
    
}
