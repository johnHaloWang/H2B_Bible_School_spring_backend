package com.can2u.app.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.can2u.app.shared.dto.RoleDto;
import com.can2u.app.shared.dto.UserDto;
import com.can2u.app.shared.dto.UserRoleDto;

public interface UserService extends UserDetailsService{
	
	UserDto createUser(UserDto user);
	
	UserDto createUserWithRoleName(UserDto user, String roleName);
	UserDto createUserWithRoleRoldId(UserDto user, String roldId);
	UserDto createUserWithRoleRold(UserDto user, RoleDto rold);
	
	UserDto getUser(String email);
	UserDto getUserByUserId(String userId);
	UserDto updateUser(String id, UserDto user);
	void deleteUser(String userId);
	List<UserDto> getUsers(int page, int limit);
	
	UserDto addRoleToUser(UserDto user, RoleDto role);
	
	void deleteRoleToUser(UserDto user, RoleDto role);
	
	
	
	
	
	UserRoleDto getUserRoles(String email);
	
	
}
