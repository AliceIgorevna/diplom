package com.epam.demennikova.fashion.daoIMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.demennikova.fashion.dao.MySQLConnector;
import com.epam.demennikova.fashion.dao.ProductDao;
import com.epam.demennikova.fashion.entity.Product;

public class ProductService implements ProductDao {

	private Connection connection;
	private static final String SQL_ADD_PRODUCT = "INSERT INTO Product (ProductName, ProductDesc) VALUES (?,?)";
	private static final String SQL_DELETE_PRODUCT = "DELETE FROM Product WHERE ProductName rlike '?'";
	private static final String SQL_UPDATE_PRODUCT = "UPDATE Product SET ProductName=?, ProductDesc=? WHERE idProduct=?";
	private static final String SQL_GET_ALL_PRODUCT = "SELECT * FROM Product";
	private static final String SQL_GET_PRODUCT_BY_ID = "SELECT * FROM Product WHERE idProduct=?";

	public ProductService() throws Exception {
		connection = MySQLConnector.getConnection();
	}

	private Product extractProduct(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setIdProduct(rs.getInt("idProduct"));
		product.setProductName(rs.getString("productName"));
		product.setProductDesc(rs.getString("productDesc"));
		return product;
	}

	public void addProduct(String productName, String productDesc) {
		PreparedStatement prst = null;
		Connection con = connection;
		try {
			prst = con.prepareStatement(SQL_ADD_PRODUCT);
			prst.setString(1, productName);
			prst.setString(2, productDesc);
			prst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProduct(String productName) {
		PreparedStatement prst = null;
		try {
			prst = connection.prepareStatement(SQL_DELETE_PRODUCT);
			prst.setString(1, productName);
			prst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateProduct(String productName, String productDesc,
			int idProduct) {
		PreparedStatement prst = null;
		Connection con = connection;
		try {
			prst = con.prepareStatement(SQL_UPDATE_PRODUCT);
			prst.setString(1, productName);
			prst.setString(2, productDesc);
			prst.setInt(3, idProduct);
			prst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_GET_ALL_PRODUCT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				productList.add(extractProduct(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	public Product getProductById(int idProduct) {
		Product product = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_GET_PRODUCT_BY_ID);
			pstmt.setInt(1, idProduct);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = extractProduct(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

}
