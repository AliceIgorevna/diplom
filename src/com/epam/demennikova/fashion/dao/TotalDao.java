package com.epam.demennikova.fashion.dao;

import java.util.List;

import com.epam.demennikova.fashion.entity.Total;

public interface TotalDao {

	public void addTotal(int userDataId, int discountId, int productId);

	public void deleteTotalByUserId(int userDataId);

	public void deleteTotalByDiscountId(int discountId);

	public void deleteTotalByProductId(int productId);

	public List<Total> getAllTatals();
}
