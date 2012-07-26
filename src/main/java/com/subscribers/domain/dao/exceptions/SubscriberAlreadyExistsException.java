package com.subscribers.domain.dao.exceptions;

public class SubscriberAlreadyExistsException extends Exception {

	public SubscriberAlreadyExistsException() {
		super("400: Subscriber already exists!");
	}
}
