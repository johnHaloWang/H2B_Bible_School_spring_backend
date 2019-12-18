package com.can2u.app.ui.response;

import java.util.Date;
import java.util.List;


public class RoleRest {
	private String roleId;
	private String roleName;
	private List<UserRoleRest> userRoles;
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
	public List<UserRoleRest> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UserRoleRest> userRoles) {
		this.userRoles = userRoles;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
}
