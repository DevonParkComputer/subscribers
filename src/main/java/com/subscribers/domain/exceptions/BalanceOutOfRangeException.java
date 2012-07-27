package com.subscribers.domain.exceptions;

public class BalanceOutOfRangeException extends Exception {

	public BalanceOutOfRangeException() {
		super("300: Balance is out of range!");
	}
}