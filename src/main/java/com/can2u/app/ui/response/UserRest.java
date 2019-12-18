package com.can2u.app.ui.response;

import java.util.Date;
import java.util.List;



public class UserRest {
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String chineseName;
	private List<UserRoleRest> userRole;
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

	public void setUserRole(List<UserRoleRest> userRole) {
		this.userRole = userRole;
	}

	public List<UserRoleRest> getUserRole() {
		return userRole;
	}

	public void setUserRoleDetails(List<UserRoleRest> userRole) {
		this.userRole = userRole;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}



}
