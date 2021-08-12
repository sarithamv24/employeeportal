package com.emp.portal.employeeportal.exception;

public class EmployeeAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}
}
