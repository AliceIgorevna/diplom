package com.epam.demennikova.fashion.daoIMP;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.demennikova.fashion.dao.DiscountDao;
import com.epam.demennikova.fashion.dao.MySQLConnector;
import com.epam.demennikova.fashion.entity.Discount;

public class DiscountService implements DiscountDao {

	private Connection connection;
	private static final String SQL_DELETE_DISCOUNT = "DELETE FROM Discount WHERE idDiscount = ?";
	private static final String SQL_GET_ALL_DISC = "SELECT * FROM Discount";
	private static final String SQL_GET_DISCOUNT_BY_ID = "SELECT * FROM discount WHERE idDiscount = ?";
	private static final String SQL_CREATE_DISCOUNT = "INSERT INTO discount VALUES (DEFAULT, ?, ?, ?)";
	private static final String SQL_UPDATE_DISCOUNT_DATE = "UPDATE `fashiondb`.`discount` SET `DiscountEndDate`=? WHERE `idDiscount`=?;";
	private static final String SQL_UPDATE_DISCOUNT_DATE_BY_CODE = "UPADATE Discount SET DiscountEndDate=? WHERE UniqCode=?";

	public DiscountService() {
		connection = MySQLConnector.getConnection();
	}

	public static String generateUniqDiscountCode() {
		Random random = new Random();
		int length = 10;
		StringBuffer captchaStringBuffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int baseCharNumber = Math.abs(random.nextInt()) % 62;
			int charNumber = 0;
			if (baseCharNumber < 26) {
				charNumber = 65 + baseCharNumber;
			} else if (baseCharNumber < 52) {
				charNumber = 97 + (baseCharNumber - 26);
			} else {
				charNumber = 48 + (baseCharNumber - 52);
			}
			captchaStringBuffer.append((char) charNumber);
		}
		return captchaStringBuffer.toString();
	}

	public static int generateDiscountAmount() {
		return (new Random().nextInt(20) + 10);
	}

	private Discount extractDiscount(ResultSet rs) throws SQLException {
		Discount discount = new Discount();
		discount.setIdDiscount(rs.getInt("idDiscount"));
		discount.setDiscountAmount(rs.getInt("DiscountAmount"));
		discount.setUniqCode(rs.getString("UniqCode"));
		discount.setEndDate(rs.getDate("DiscountEndDate"));
		return discount;
	}

	public void deleteDiscount(Integer idDiscount) {
		PreparedStatement prst = null;
		Connection con = connection;
		try {
			prst = con.prepareStatement(SQL_DELETE_DISCOUNT);
			prst.setInt(1, idDiscount);
			prst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public void createDiscount(Date endDate) {
		PreparedStatement pstmt = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_CREATE_DISCOUNT);
			pstmt.setInt(1, generateDiscountAmount());
			pstmt.setString(2, generateUniqDiscountCode());
			pstmt.setDate(3, (java.sql.Date) endDate);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			// LOG.error("Cannot add a feedback", ex);
		}
	}

	@Override
	public List<Discount> getAllDiscounts() {
		List<Discount> discountsList = new ArrayList<Discount>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_GET_ALL_DISC);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				discountsList.add(extractDiscount(rs));
			}
		} catch (SQLException ex) {
		}
		return discountsList;
	}


	public Discount getDiscountById(int idDiscount) {
		Discount discount = new Discount();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_GET_DISCOUNT_BY_ID);
			pstmt.setInt(1, idDiscount);
			res = pstmt.executeQuery();
			if (res.next()) {
				discount = extractDiscount(res);
			}
		} catch (SQLException ex) {
			System.out.println("bad day");
		}
		return discount;
	}


	@Override
	public void updateDiscount(int idDiscount, java.sql.Date endDate) {
		PreparedStatement prst = null;
		Connection con = connection;
		try {
			prst = con.prepareStatement(SQL_UPDATE_DISCOUNT_DATE);
			prst.setDate(1, endDate);
			prst.setInt(2, idDiscount);
			prst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("PIPIRKA");
		}
	}
	
	@Override
	public void updateDiscount(String UniqCode, java.sql.Date endDate) {
		PreparedStatement prst = null;
		Connection con = connection;
		try {
			prst = con.prepareStatement(SQL_UPDATE_DISCOUNT_DATE_BY_CODE);
			prst.setDate(1, endDate);
			prst.setString (2, UniqCode);
			prst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("PIPIRKA");
		}
	}

	public static void main(String[] args) {

		// TODO: discService.createDiscount(generateDiscountAmount(),
		// generateUniqDiscountCode(), new java.sql.Date(115, 1, 1));

		/*for (Discount d : new DiscountService().getAllDiscounts()) {
			System.out.println(d.toString());
		}
		DiscountService discount = new DiscountService();
		discount.updateDiscount(4, new java.sql.Date(120, 5, 5));
		for (Discount d : new DiscountService().getAllDiscounts()) {
			System.out.println(d.toString());
		}*/
		DiscountService discount = new DiscountService();
		System.out.println(discount.getDiscountById(2));
	}

	
}
