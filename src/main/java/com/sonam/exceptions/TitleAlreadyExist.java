package com.sonam.exceptions;

public class TitleAlreadyExist extends RuntimeException {

	
	public TitleAlreadyExist(String message) {
		super(message);
	}
	
	public TitleAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }
}
