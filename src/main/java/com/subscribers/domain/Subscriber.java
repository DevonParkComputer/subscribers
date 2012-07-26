package com.subscribers.domain;

import org.hibernate.validator.constraints.Range;

public class Subscriber {

	private final PhoneNumber phoneNumber;

	private final String name;

	@Range(min=0,max=1000)
	private final int balance;

	private final float decrementRate;

	public Subscriber(
			PhoneNumber phoneNumber,
			String name,
			int balance,
			float decrementRate) {
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.balance = balance;
		this.decrementRate = decrementRate;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public float getDecrementRate() {
		return decrementRate;
	}
}
