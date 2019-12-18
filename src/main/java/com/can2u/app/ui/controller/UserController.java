package com.can2u.app.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.can2u.app.exceptions.UserServiceException;
import com.can2u.app.service.UserService;
import com.can2u.app.shared.dto.UserDto;
import com.can2u.app.ui.model.request.UserDetialRequestModel;
import com.can2u.app.ui.response.ErrorMessages;
import com.can2u.app.ui.response.OperationStatusModel;
import com.can2u.app.ui.response.RequestOperationStatus;
import com.can2u.app.ui.response.UserRest;



@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest getUser(@PathVariable String id) {
		UserRest returnValue = new UserRest();
		UserDto userDto = userService.getUserByUserId(id);
		BeanUtils.copyProperties(userDto, returnValue);
		return returnValue;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest createUser(@RequestBody UserDetialRequestModel userDetails) throws Exception {
		UserRest returnValue = new UserRest();

		if (userDetails.getLastName() == null || userDetails.getLastName().isEmpty())
			throw new UserServiceException(ErrorMessages.MISS_REQUIRED_FIELD.getErrorMessage());

		if (userDetails.getFirstName() == null || userDetails.getFirstName().isEmpty())
			throw new UserServiceException(ErrorMessages.MISS_REQUIRED_FIELD.getErrorMessage());

		if (userDetails.getEmail() == null || userDetails.getEmail().isEmpty())
			throw new Exception(ErrorMessages.MISS_REQUIRED_FIELD.getErrorMessage());

		if (userDetails.getPassword() == null || userDetails.getPassword().isEmpty())
			throw new Exception(ErrorMessages.MISS_REQUIRED_FIELD.getErrorMessage());

		if (userDetails.getPassword().isEmpty())
			throw new Exception(ErrorMessages.MISS_REQUIRED_FIELD.getErrorMessage());

		
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		
		
		UserDto createdUser = userService.createUser(userDto);
		returnValue = modelMapper.map(createdUser, UserRest.class);
		return returnValue;
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_ATOM_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_ATOM_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String id, @RequestBody UserDetialRequestModel userDetails) {
		
		UserRest returnValue = new UserRest();
		UserDto userDto = userService.getUserByUserId(id);
		BeanUtils.copyProperties(userDetails, userDto);
		UserDto updateUser = userService.updateUser(id, userDto);
		BeanUtils.copyProperties(updateUser, returnValue);
		return returnValue;
		
	}

	@DeleteMapping(path = "/{id}", consumes = { MediaType.APPLICATION_ATOM_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_ATOM_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel deleteUser(@PathVariable String id) {
		
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		
		userService.deleteUser(id);
		
		returnValue.setOperationResult(RequestOperationStatus.SUCCESSS.name());
		return returnValue;
		
	}
	//user?page=1&limit=10
	@GetMapping(produces = { MediaType.APPLICATION_ATOM_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public List<UserRest> getUsers(@RequestParam(value="page", defaultValue="0") int page, 
			@RequestParam(value="limit", defaultValue="25") int limit){
		List<UserRest>returnValue = new ArrayList<>();
		
		List<UserDto>users = userService.getUsers(page, limit);
		
		for(UserDto userDto: users) {
			UserRest userModel = new UserRest();
			BeanUtils.copyProperties(userDto, userModel);
			returnValue.add(userModel);
		}
		return returnValue;
	}
}
