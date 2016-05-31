package com.epam.demennikova.fashion.dao;

import java.util.List;

import com.epam.demennikova.fashion.entity.UserRole;

public interface UserRoleDao {
	
	public void addRole(String roleName);
	
	public void deleteUserRole(int idUserRole);
	
	public List<UserRole> getAllRoles();
	
	public UserRole getUsersByRoleId(int idUserRole);
	

}
