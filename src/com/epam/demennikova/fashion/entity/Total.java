package com.epam.demennikova.fashion.entity;

public class Total {
	private int idTotal;
	private int userDataId;
	private int discountId;
	private int productId;
	
	public int getIdTotal() {
		return idTotal;
	}
	public void setIdTotal(int idTotal) {
		this.idTotal = idTotal;
	}
	public int getUserDataId() {
		return userDataId;
	}
	public void setUserDataId(int userDataId) {
		this.userDataId = userDataId;
	}
	public int getDiscountId() {
		return discountId;
	}
	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "Total [idTotal=" + idTotal + ", userDataId=" + userDataId
				+ ", discountId=" + discountId + ", productId=" + productId
				+ "]";
	}
}
