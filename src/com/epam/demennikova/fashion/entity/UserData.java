package com.epam.demennikova.fashion.entity;

import java.sql.Date;

public class UserData {
	private int idUserData;
	private String email;
	private String password;
	private Date birthDate;
	private int idRole;
	
	public int getIdUserData() {
		return idUserData;
	}
	public void setIdUserData(int idUserData) {
		this.idUserData = idUserData;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public int getRoleId() {
		return idRole;
	}
	public void setRoleId(int idRole) {
		this.idRole = idRole;
	}
	@Override
	public String toString() {
		return "UserData [idUserData=" + idUserData + ", email=" + email
				+ ", password=" + password + ", birthDate=" + birthDate
				+ ", idRole=" + idRole + "]";
	}
}
