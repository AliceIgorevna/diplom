package com.epam.demennikova.fashion.daoIMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.demennikova.fashion.dao.MySQLConnector;
import com.epam.demennikova.fashion.dao.TotalDao;
import com.epam.demennikova.fashion.entity.Total;

public class TotalService implements TotalDao {

	private Connection connection;
	private static final String SQL_ADD_TOTAL = "INSERT INTO fashiondb.Total VALUES (DEFAULT, ?, ?, ?)";
	private static final String SQL_DELETE_BY_USER_ID = "DELETE FROM fashiondb.Total WHERE UserData_idUserData=?";
	private static final String SQL_DELETE_BY_PRODUCT = "DELETE FROM fashiondb.Total WHERE Product_idProduct=?";
	private static final String SQL_DELETE_BY_DISCOUNT = "DELETE FROM fashiondb.Total WHERE Discount_idDiscount=?";
	private static final String SQL_GET_TOTAL = "SELECT * FROM fashiondb.Total";
	private static final String SQL_GET_TOTAL_FOR_USER = "SELECT * FROM fashiondb.Total WHERE UserData_idUserData=? ";

	public TotalService() {
		connection = MySQLConnector.getConnection();
	}

	private Total extractTotal(ResultSet rs) throws SQLException{
		Total total = new Total();
		total.setIdTotal(rs.getInt("idTotal"));
		total.setUserDataId(rs.getInt("UserData_idUserData"));
		total.setDiscountId(rs.getInt("Discount_idDiscount"));
		total.setProductId(rs.getInt("Product_idProduct"));
		return total;
	}

	public void addTotal(int userDataId, int discountId, int productId) {
		PreparedStatement pstmt = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_ADD_TOTAL);
			pstmt.setInt(1, userDataId);
			pstmt.setInt(2, discountId);
			pstmt.setInt(3, productId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteTotalByUserId(int userDataId) {
		PreparedStatement pstmt = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_DELETE_BY_USER_ID);
			pstmt.setInt(1, userDataId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTotalByDiscountId(int discountId) {
		PreparedStatement pstmt = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_DELETE_BY_DISCOUNT);
			pstmt.setInt(1, discountId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTotalByProductId(int productId) {
		PreparedStatement prst = null;
		Connection con = connection;
		try {
			prst = con.prepareStatement(SQL_DELETE_BY_PRODUCT);
			prst.setInt(1, productId);
			prst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Total> getAllTatals() {
		List<Total> totalList = new ArrayList<Total>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_GET_TOTAL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				totalList.add(extractTotal(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return totalList;
	}
	
	public Total getAllTatalForUser(int userId) {
		Total total = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_GET_TOTAL_FOR_USER);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				total = extractTotal(rs);
			}
			return total;
		} catch (SQLException ex) {
			
		}
		return null;
	}
	
	public static void main(String[] args) {
		TotalService t = new TotalService();
		System.out.println(t.getAllTatalForUser(3));
	}

}
