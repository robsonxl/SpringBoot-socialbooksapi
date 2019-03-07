package com.rxl.socialbooks.service.exception;

public class AutorNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9189859660838814186L;
	
	public AutorNaoEncontradoException(String message) {
		super(message);
	}
	public AutorNaoEncontradoException(String message, Throwable cause) {
		super(message,cause);
	}
}
