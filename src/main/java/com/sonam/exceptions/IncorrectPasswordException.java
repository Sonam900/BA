package com.sonam.exceptions;


public class IncorrectPasswordException extends RuntimeException {

	private String message;
	
	public IncorrectPasswordException(String message) {
	super();
	this.message= message;
	}
}
