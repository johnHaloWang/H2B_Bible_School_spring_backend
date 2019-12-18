package com.can2u.app.service;

import java.util.List;

import com.can2u.app.shared.dto.RoleDto;
import com.can2u.app.shared.dto.UserDto;
import com.can2u.app.shared.dto.UserRoleDto;

public interface UserRoleService {
	UserRoleDto createUserRole(UserDto userDto, RoleDto role);
	void deleteUserRole(UserDto userDto, RoleDto role);
	List<UserRoleDto> getUserRole(UserDto userDto);	
	
	
	
}
