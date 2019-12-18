package com.can2u.app.ui.response;

public enum ErrorMessages {
	MISS_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
	RECORD_ALREADY_EXISTS("Record already exits"),
	INTERNAL_SERVER_ERROR("Internal server error"),
	NO_RECORD_FOUND("Record with provided id is not found"),
	AUTHENTICATION_FAILED("Authentication failed"),
	COULD_NOT_UPDATE_RECORD("Could not update record"),
	COULD_NOT_DELETE_RECORD("Could not delete record"),
	EMAIL_ADDRESS_NOT_VERIFIED("Email address could not be verified");
	
	private String errorMessage;

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}