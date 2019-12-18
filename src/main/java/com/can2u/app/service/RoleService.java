package com.can2u.app.service;

import java.util.List;

import com.can2u.app.shared.dto.RoleDto;

public interface RoleService {
	RoleDto createRole(RoleDto Role);
	RoleDto getRole(String name);
	RoleDto getRoleByRoleId(String RoleId);
	RoleDto updateRole(String id, RoleDto Role);
	void deleteRole(String RoleId);
	List<RoleDto> getRoles(int page, int limit);
}
