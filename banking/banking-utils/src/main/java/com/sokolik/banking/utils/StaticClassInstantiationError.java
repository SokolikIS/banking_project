package com.sokolik.banking.utils;

public class StaticClassInstantiationError extends InstantiationError {

	private static final long serialVersionUID = 1L;

	public StaticClassInstantiationError() {
		super("Class contains static methods only. You should not instantiate it!");
	}
}
