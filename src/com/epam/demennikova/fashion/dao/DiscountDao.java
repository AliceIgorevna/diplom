package com.epam.demennikova.fashion.dao;

import java.util.Date;
import java.util.List;

import com.epam.demennikova.fashion.entity.Discount;

public interface DiscountDao {
	
	public void createDiscount(Date endDate);
	
	public void deleteDiscount(Integer idDiscount);
	
	public List<Discount> getAllDiscounts();
	
	public Discount getDiscountById(int idDiscount);
	
	public void updateDiscount(int idDiscount, java.sql.Date endDate); 
	
	public void updateDiscount(String  UniqCode, java.sql.Date endDate);
}
