package com.algoworks.flight.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class DataIntegrityException extends DataIntegrityViolationException {

	public DataIntegrityException(String msg) {
		super(msg);
		System.out.println("exception");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
