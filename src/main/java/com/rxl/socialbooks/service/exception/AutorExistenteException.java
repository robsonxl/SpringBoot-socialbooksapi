package com.rxl.socialbooks.service.exception;

public class AutorExistenteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9189859660838814186L;
	
	public AutorExistenteException(String message) {
		super(message);
	}
	public AutorExistenteException(String message, Throwable cause) {
		super(message,cause);
	}
}
