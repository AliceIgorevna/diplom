package com.epam.demennikova.fashion.entity;


public class Product {
	private int idProduct;
	private String productName;
	private String productDesc;
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", productName="
				+ productName + ", productDesc=" + productDesc + "]";
	}
}
