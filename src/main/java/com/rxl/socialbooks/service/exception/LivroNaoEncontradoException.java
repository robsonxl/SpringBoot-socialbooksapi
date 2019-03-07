package com.rxl.socialbooks.service.exception;

public class LivroNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9189859660838814186L;
	
	public LivroNaoEncontradoException(String message) {
		super(message);
	}
	public LivroNaoEncontradoException(String message, Throwable cause) {
		super(message,cause);
	}
}
