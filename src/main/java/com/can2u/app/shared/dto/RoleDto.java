package com.can2u.app.shared.dto;

import java.util.List;

public class RoleDto {
	
	private String roleId;
	private String roleName;
	private List<UserRoleDto> userRoles;
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}
	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<UserRoleDto> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoleDto> userRoles) {
		this.userRoles = userRoles;
	}

	
	
	







}
