package com.totvs.entrevista.pessoa.service.exceptions;
public class TelefoneUnicoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TelefoneUnicoException(String msg) {
		super(msg);
	}
	
	public TelefoneUnicoException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}