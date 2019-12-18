package com.can2u.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.can2u.app.exceptions.RoleServiceException;
import com.can2u.app.io.entity.RoleEntity;
import com.can2u.app.io.repository.RoleRepository;
import com.can2u.app.service.RoleService;
import com.can2u.app.shared.Utils;
import com.can2u.app.shared.dto.RoleDto;
import com.can2u.app.ui.response.ErrorMessages;

@Service
public class RoleServiceLmpl implements RoleService{

	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	Utils utils;
	
	@Override
	public RoleDto createRole(RoleDto role) {
		if (roleRepository.findByRoleName(role.getRoleName()) != null)
			throw new RoleServiceException(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage());
		
		
		RoleEntity roleEntity = new RoleEntity();
		ModelMapper modelMapper = new ModelMapper();
		roleEntity= modelMapper.map(role, RoleEntity.class);
		
		String publicRoleId = utils.generateRoleId(30);
		
		
		roleEntity.setRoleId(publicRoleId);
		roleEntity.setRoleName(role.getRoleName());
		roleEntity.setCreate_At(new Date());
		RoleEntity storedRoleDetails = roleRepository.save(roleEntity);

		RoleDto returnValue = new RoleDto();
		
		returnValue= modelMapper.map(storedRoleDetails, RoleDto.class);
		return returnValue;
	}

	@Override
	public RoleDto getRole(String name) {
		RoleDto returnValue = new RoleDto();
		ModelMapper modelMapper = new ModelMapper();
		RoleEntity roleEntity = roleRepository.findByRoleName(name);
		
		if(roleEntity == null)
			throw new RoleServiceException("Role name: " + name + "can't be found");
		
		returnValue= modelMapper.map(roleEntity, RoleDto.class);
		return returnValue;
	}

	@Override
	public RoleDto getRoleByRoleId(String RoleId) {
		RoleDto returnValue = new RoleDto();
		ModelMapper modelMapper = new ModelMapper();
		RoleEntity roleEntity = roleRepository.findByRoleId(RoleId);
		
		if(roleEntity == null)
			throw new RoleServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		
		returnValue= modelMapper.map(roleEntity, RoleDto.class);
		return returnValue;
	}

	@Override
	public RoleDto updateRole(String id, RoleDto role) {
		RoleDto returnValue = new RoleDto();
		ModelMapper modelMapper = new ModelMapper();
		RoleEntity roleEntity = roleRepository.findByRoleId(id);
		
		if(roleEntity == null)
			throw new RoleServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		roleEntity.setRoleId(role.getRoleId());
		roleEntity.setRoleName(role.getRoleName());
		roleEntity.setUpdate_At(new Date());
		
		RoleEntity updatedRoleDatails = roleRepository.save(roleEntity);
		
		returnValue= modelMapper.map(updatedRoleDatails, RoleDto.class);
		return returnValue;
	}

	@Override
	public void deleteRole(String roleId) {
		RoleEntity roleEntity = roleRepository.findByRoleId(roleId);
		
		if(roleEntity == null)
			throw new RoleServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		
		roleRepository.delete(roleEntity);
		
	}

	@Override
	public List<RoleDto> getRoles(int page, int limit) {
		List<RoleDto> returnValue = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		Pageable pageableRequest = PageRequest.of(page,  limit);
		
		Page<RoleEntity>rolesPage = roleRepository.findAll(pageableRequest);
		List<RoleEntity>roles = rolesPage.getContent();
		
		for (RoleEntity roleEntity: roles) {
			RoleDto roleDto = new RoleDto();
			roleDto = modelMapper.map(roleEntity, RoleDto.class);
			returnValue.add(roleDto);
		}
		return returnValue;
	}

}
