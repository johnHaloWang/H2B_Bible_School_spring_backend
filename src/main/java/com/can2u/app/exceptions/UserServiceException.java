package com.can2u.app.exceptions;

public class UserServiceException extends RuntimeException{
	
	private static final long serialVersionUID = -2219609999507180474L;

	public UserServiceException(String message) {
		super(message);
	}
}