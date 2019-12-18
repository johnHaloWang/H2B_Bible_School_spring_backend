package com.can2u.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.can2u.app.io.repository.RoleRepository;
import com.can2u.app.io.repository.UserRepository;
import com.can2u.app.service.RoleService;
import com.can2u.app.service.UserRoleService;
import com.can2u.app.shared.Utils;
import com.can2u.app.shared.dto.RoleDto;
import com.can2u.app.shared.dto.UserDto;
import com.can2u.app.shared.dto.UserRoleDto;

public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleServiceLmpl roleService;
	
	@Autowired
	RoleRepository userRoleRepository;

	@Autowired
	Utils utils;

	@Override
	public UserRoleDto createUserRole(UserDto userDto, RoleDto role) {
		
		
		
		return null;
	}

	@Override
	public void deleteUserRole(UserDto userDto, RoleDto role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserRoleDto> getUserRole(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
