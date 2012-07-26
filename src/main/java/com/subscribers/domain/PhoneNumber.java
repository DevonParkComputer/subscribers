package com.subscribers.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

public class PhoneNumber {

	@Length(min=10,max=10)
	@Pattern(regexp="^(\\d)*$")
	private final String digits;

	//todo: enforce validation
	public PhoneNumber(String digits) {
		this.digits = digits;
	}

	String getDigits() {
		return digits;
	}
}
