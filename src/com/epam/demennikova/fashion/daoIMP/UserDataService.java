package com.epam.demennikova.fashion.daoIMP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.demennikova.fashion.dao.MySQLConnector;
import com.epam.demennikova.fashion.dao.UserDataDao;
import com.epam.demennikova.fashion.entity.UserData;

public class UserDataService implements UserDataDao {
	private Connection connection;
	private static final String SQL_FIND_BY_EMAIL_AND_PASSWORD = "SELECT * FROM UserData WHERE email=? AND password=?";
	private static final String SQL_GET_ALL_USERS = "select * from UserData";
	private static final String SQL_DELETE_USER = "delete from UserData where idUserData=?";
	private static final String SQL_ADD_USER = "INSERT INTO UserData VALUES (DEFAULT, ?, ?, ?, '1')";
	private static final String SQL_GET_BY_USER_ID = "SELECT * FROM UserData WHERE idUserData = ? ";
	private static final String SQL_UPDATE_USER_DATA = "UPDATE users SET email=?, password=?, birthDate=? WHERE idUserData=?";
	private static final String SQL_UPDATE_ROLE = "UPDATE users SET role=? WHERE id_user=?";
	private static final String SQL_CHECH_FOR_MATCHES = "SELECT * FROM UserData WHERE email=?;";

	public UserDataService() {
		connection = MySQLConnector.getConnection();
	}

	private UserData extractUser(ResultSet rs) throws SQLException {
		UserData userData = new UserData();
		userData.setIdUserData(rs.getInt("idUserData"));
		userData.setEmail(rs.getString("email"));
		userData.setPassword(rs.getString("password"));
		userData.setBirthDate(rs.getDate("birthDate"));
		userData.setRoleId(rs.getInt("userrole_iduserrole"));
		return userData;
	}

	public UserData getUserByEmailPassword(String email, String password) {
		UserData userData = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_FIND_BY_EMAIL_AND_PASSWORD);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userData = extractUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userData;
	}

	public boolean addUser(String email, String password, Date birthDate) {
		PreparedStatement pstmt = null;
		Connection con = connection;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(SQL_CHECH_FOR_MATCHES);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			boolean flag = true;
			while (rs.next()) {
				flag = false;
			}
			if (flag) {
				pstmt = con.prepareStatement(SQL_ADD_USER);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				pstmt.setDate(3, birthDate);
				pstmt.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public void deleteUser(Integer idUserData) {
		PreparedStatement prst = null;
		Connection con = connection;
		try {
			prst = con.prepareStatement(SQL_DELETE_USER);
			prst.setInt(1, idUserData);
			prst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<UserData> getAllUsers() {

		List<UserData> userDataList = new ArrayList<UserData>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_GET_ALL_USERS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userDataList.add(extractUser(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return userDataList;
	}

	@Override
	public UserData getUserById(Integer idUserData) {
		UserData userData = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_GET_BY_USER_ID);
			pstmt.setInt(1, idUserData);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userData = extractUser(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return userData;
	}

	@Override
	public void updateUserRole(Integer idUserData, int idRole) {
		PreparedStatement prst = null;
		Connection con = connection;
		try {
			prst = con.prepareStatement(SQL_UPDATE_ROLE);
			prst.setInt(2, idUserData);
			prst.setInt(1, idRole);
			prst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateUser(String email, String password, Date birthDate) {

		PreparedStatement prst = null;
		Connection con = connection;
		try {
			prst = con.prepareStatement(SQL_UPDATE_USER_DATA);
			prst.setString(1, email);
			prst.setString(2, password);
			prst.setDate(3, birthDate);
			prst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UserDataService u = new UserDataService();
		for (UserData object : u.getAllUsers()) {
			System.out.println(object.toString());
		}
		System.out.println();
		System.out.println(u.getUserByEmailPassword("ddbb@mail.ru", "222"));
	}
}
