package com.subscribers.domain.builders;

import com.subscribers.domain.PhoneNumber;
import com.subscribers.domain.exceptions.PhoneNumberException;

public class PhoneNumberBuilder {

	private String digits;

	public PhoneNumberBuilder digits(String digits) {
		this.digits = digits;
		return this;
	}

	public PhoneNumber build()
	throws PhoneNumberException {

		return new PhoneNumber(digits);
	}
}
