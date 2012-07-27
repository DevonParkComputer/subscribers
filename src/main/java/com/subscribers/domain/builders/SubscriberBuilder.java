package com.subscribers.domain.builders;

import com.subscribers.domain.PhoneNumber;
import com.subscribers.domain.Subscriber;
import com.subscribers.domain.exceptions.BalanceOutOfRangeException;

public class SubscriberBuilder {

	private PhoneNumber phoneNumber;
	private String name;
	private int balance;
	private int decrementRate;

	public SubscriberBuilder phoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public SubscriberBuilder name(String name) {
		this.name = name;
		return this;
	}

	public SubscriberBuilder balance(int balance) {
		this.balance = balance;
		return this;
	}

	public SubscriberBuilder decrementRate(int decrementRate) {
		this.decrementRate = decrementRate;
		return this;
	}

	public Subscriber build()
	throws BalanceOutOfRangeException {
		return new Subscriber(phoneNumber, name, balance, decrementRate);
	}
}
