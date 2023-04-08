package com.totvs.entrevista.pessoa.service.exceptions;
public class NaoEncontradoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NaoEncontradoException(String msg) {
		super(msg);
	}
	
	public NaoEncontradoException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}