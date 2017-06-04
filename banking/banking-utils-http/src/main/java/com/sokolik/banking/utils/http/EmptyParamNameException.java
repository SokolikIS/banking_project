package com.sokolik.banking.utils.http;

public class EmptyParamNameException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public EmptyParamNameException() {
		super("You trying to read parameter for emty name! parameter name can not be empty!");
	}
}
