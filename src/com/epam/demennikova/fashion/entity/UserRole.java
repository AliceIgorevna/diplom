package com.epam.demennikova.fashion.entity;


public class UserRole {
	private int idUserRole;
	private String roleName;
	public int getIdUserRole() {
		return idUserRole;
	}
	public void setIdUserRole(int idUserRole) {
		this.idUserRole = idUserRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "UserRole [idUserRole=" + idUserRole + ", roleName=" + roleName
				+ "]";
	}
}
