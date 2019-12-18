package com.can2u.app.ui.response;

import java.util.Date;

public class UserRoleRest {
	private String userRoleId;
	private UserRest userDetials;
	private RoleRest roleDetials;
	private Date create_At;
    private Date update_At;
    
	public Date getCreate_At() {
		return create_At;
	}
	public void setCreate_At(Date create_At) {
		this.create_At = create_At;
	}
	public Date getUpdate_At() {
		return update_At;
	}
	public void setUpdate_At(Date update_At) {
		this.update_At = update_At;
	}
	public String getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	public UserRest getUserDetials() {
		return userDetials;
	}
	public void setUserDetials(UserRest userDetials) {
		this.userDetials = userDetials;
	}
	public RoleRest getRoleDetials() {
		return roleDetials;
	}
	public void setRoleDetials(RoleRest roleDetials) {
		this.roleDetials = roleDetials;
	}
}
