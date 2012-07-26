package com.subscribers.domain.dao.exceptions;

public class SubscriberNotFoundException extends Exception {

	public SubscriberNotFoundException() {
		super("200: Subscriber does not exist!");
	}
}
