package com.example.userserviceapi.exceptions;

public class InvalidAgeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;

	public InvalidAgeException(int code) {
		super();
		this.code = code;
	}

	@Override
	public String getMessage() {
		String mensaje = "";
		
		switch(code) {
		case 400:
			mensaje = "Edad inválida";
			break;
		}
		
		return mensaje;
	}
	
	

}
