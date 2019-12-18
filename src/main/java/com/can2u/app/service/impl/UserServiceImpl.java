package com.can2u.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.can2u.app.io.entity.UserEntity;
import com.can2u.app.io.repository.RoleRepository;
import com.can2u.app.io.repository.UserRepository;
import com.can2u.app.service.UserService;
import com.can2u.app.shared.dto.RoleDto;
import com.can2u.app.shared.dto.UserDto;
import com.can2u.app.shared.dto.UserRoleDto;
import com.can2u.app.ui.response.ErrorMessages;
import com.can2u.app.shared.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleServiceLmpl roleService;

	@Autowired
	Utils utils;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto user) {

		if (userRepository.findByEmail(user.getEmail()) != null)
			throw new RuntimeException("Record already exists");
		
		for(int i = 0; i<user.getUserRoles().size(); i++) {
			UserRoleDto temp = user.getUserRoles().get(i);
			temp.setUserDetials(user);
			temp.setUserRoleId(utils.generateUserRoleId(30));
			
			
			
			user.getUserRoles().set(i,temp);
		}
		
		
		UserEntity userEntity = new UserEntity();
		ModelMapper modelMapper = new ModelMapper();
		userEntity= modelMapper.map(user, UserEntity.class);
		
		String publicUserId = utils.generateUserId(30);
		
		
		userEntity.setUserId(publicUserId);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setCreate_At(new Date());
		UserEntity storedUserDetails = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		
		//BeanUtils.copyProperties(storedUserDetails, returnValue);
		returnValue= modelMapper.map(storedUserDetails, UserDto.class);
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		return new User(userEntity.getEmail(), 
						userEntity.getEncryptedPassword(), 
						new ArrayList<>());
		

	}

	@Override
	public UserDto getUser(String email) {
		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null)
			throw new UsernameNotFoundException(email);
		
		BeanUtils.copyProperties(userEntity,  returnValue);
		
		return returnValue;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userId);
		
		if(userEntity == null)
			throw new UsernameNotFoundException("User with ID: " + userId + " not found");
		
		BeanUtils.copyProperties(userEntity,  returnValue);
		
		return returnValue;
	}

	@Override
	public UserDto updateUser(String userId, UserDto user) {
		
		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userId);
		
		if(userEntity == null)
			throw new UsernameNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setUpdate_At(new Date());
		
		UserEntity updatedUserDatails = userRepository.save(userEntity);
		BeanUtils.copyProperties(updatedUserDatails, returnValue);
		
		
		return returnValue;
	}

	@Override
	public void deleteUser(String userId) {
		
		UserEntity userEntity = userRepository.findByUserId(userId);
		
		if(userEntity == null)
			throw new UsernameNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		
		userRepository.delete(userEntity);
		
		
	}

	@Override
	public List<UserDto> getUsers(int page, int limit) {
		
		List<UserDto> returnValue = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page,  limit);
		
		Page<UserEntity>usersPage = userRepository.findAll(pageableRequest);
		List<UserEntity>users = usersPage.getContent();
		
		for (UserEntity userEntity: users) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(userEntity, userDto);
			returnValue.add(userDto);
		}
		return returnValue;
	}

	@Override
	public UserDto createUserWithRoleName(UserDto user, String roleName) {
	
		
	}

	@Override
	public UserDto createUserWithRoleRoldId(UserDto user, String roldId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto createUserWithRoleRold(UserDto user, RoleDto rold) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto addRoleToUser(UserDto user, RoleDto role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRoleToUser(UserDto user, RoleDto role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserRoleDto getUserRoles(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
