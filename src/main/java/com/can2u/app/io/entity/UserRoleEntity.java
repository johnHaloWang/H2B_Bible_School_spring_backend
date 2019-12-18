package com.can2u.app.io.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity(name="user_roles")
public class UserRoleEntity implements Serializable{


	private static final long serialVersionUID = 2227463549032295087L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(length = 30, nullable = false)
	private String UserRoleId;
	
	

	@ManyToOne
	@JoinColumn(name = "users_id")
	@JsonIgnore
	private UserEntity userDetials;
	
	@ManyToOne
	@JoinColumn(name = "roles_id")
	@JsonIgnore
	private RoleEntity roleDetials;
	
	private Date create_At;
    private Date update_At;

    @PrePersist
    protected void onCreate(){
        this.create_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.update_At = new Date();
    }
    
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
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserRoleId() {
		return UserRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		UserRoleId = userRoleId;
	}

	public UserEntity getUserDetials() {
		return userDetials;
	}

	public void setUserDetials(UserEntity userDetials) {
		this.userDetials = userDetials;
	}

	public RoleEntity getRoleDetials() {
		return roleDetials;
	}

	public void setRoleDetials(RoleEntity roleDetials) {
		this.roleDetials = roleDetials;
	}

	

}
