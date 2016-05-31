package com.epam.demennikova.fashion.dao;

import java.sql.Date;
import java.util.List;

import com.epam.demennikova.fashion.entity.UserData;

public interface UserDataDao {

	public boolean addUser(String email, String password, Date birthDate); // что делать с роль ид?
	
	public void deleteUser(Integer idUserData);
	
	public List<UserData> getAllUsers();
	
	public UserData getUserById(Integer idUserData);
	
	public UserData getUserByEmailPassword(String email, String password);
	
	public void updateUserRole(Integer idUserData, int idRole);
	
	public void updateUser(String email, String password, Date birthDate);
}
