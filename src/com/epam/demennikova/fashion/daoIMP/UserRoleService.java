package com.epam.demennikova.fashion.daoIMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.demennikova.fashion.dao.MySQLConnector;
import com.epam.demennikova.fashion.dao.UserRoleDao;
import com.epam.demennikova.fashion.entity.UserRole;

public class UserRoleService implements UserRoleDao {

	private static final String SQL_ADD_ROLE = "INSERT INTO UserRole VALUES (DEFAULT, ?)";
	private static final String SQL_GET_ALL_ROLES = "SELECT * FROM UserRole";
	private static final String SQL_GET_ROLE_BY_ID = "SELECT * FROM UserRole WHERE idUserRole = ? ";
	private static final String SQL_DELETE_ROLE = "DELETE FROM  UserRole WHERE idUserRole = ?";
	
	
	private Connection connection;

	public UserRoleService(){
		connection = MySQLConnector.getConnection();
	}

	private UserRole extractRole(ResultSet rs) throws SQLException{
		UserRole role = new UserRole();
		role.setIdUserRole(rs.getInt("idUserRole"));
		role.setRoleName(rs.getString("roleName"));
		return role;
	}

	public void addRole(String roleName) {
		PreparedStatement prst = null;
		try {
			prst = connection.prepareStatement(SQL_ADD_ROLE);
			prst.setString(1, roleName);
			prst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<UserRole> getAllRoles() {
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = connection;
		try {
			pstmt = con.prepareStatement(SQL_GET_ALL_ROLES);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			userRoleList.add(extractRole(rs));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userRoleList;
	}

	public UserRole getUsersByRoleId(int idUserRole) {
		UserRole role = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = connection;
		try{
			pstmt = con.prepareStatement(SQL_GET_ROLE_BY_ID);
			pstmt.setInt(1, idUserRole);
			pstmt.executeQuery();
			if (rs.next()) {
				role = extractRole(rs);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public void deleteUserRole(int idUserRole) {
		PreparedStatement prst = null;
		Connection con = connection;
		try {
			prst = con.prepareStatement(SQL_DELETE_ROLE);
			prst.setInt(1, idUserRole);
			prst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
