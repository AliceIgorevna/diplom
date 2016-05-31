package com.epam.demennikova.fashion.entity;

import java.util.Date;

public class Discount {
	private int idDiscount;
	private int discountAmount;
	private String uniqCode;
	private Date endDate;
	
	public int getIdDiscount() {
		return idDiscount;
	}
	public void setIdDiscount(int idDiscount) {
		this.idDiscount = idDiscount;
	}
	public int getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getUniqCode() {
		return uniqCode;
	}
	public void setUniqCode(String uniqCode) {
		this.uniqCode = uniqCode;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Discount [idDiscount=" + idDiscount + ", discountAmount="
				+ discountAmount + ", uniqCode=" + uniqCode + ", endDate="
				+ endDate + "]";
	}
}
