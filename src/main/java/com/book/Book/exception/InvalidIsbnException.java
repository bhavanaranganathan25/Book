package com.book.Book.exception;

public class InvalidIsbnException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	

	public InvalidIsbnException(String msg) {
		super();
		this.msg = msg;
	}



	public String getMsg() {
		return msg;
	}

	
}
