package com.subscribers.domain.builders;

import com.subscribers.domain.PhoneNumber;

public class PhoneNumberBuilder {

	private String digits;

	public PhoneNumberBuilder digits(String digits) {
		this.digits = digits;
		return this;
	}

	public PhoneNumber build() {
		return new PhoneNumber(digits);
	}
}
