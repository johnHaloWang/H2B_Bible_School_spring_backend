package com.can2u.app.shared.dto;

import java.io.Serializable;

public class UserRoleDto implements Serializable {

	private static final long serialVersionUID = 7386035650640095852L;
	private String userRoleId;
	private UserDto userDetials;
	private RoleDto roleDetials;

	
	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public UserDto getUserDetials() {
		return userDetials;
	}

	public void setUserDetials(UserDto userDetials) {
		this.userDetials = userDetials;
	}

	public RoleDto getRoleDetials() {
		return roleDetials;
	}

	public void setRoleDetials(RoleDto roleDetials) {
		this.roleDetials = roleDetials;
	}
}
