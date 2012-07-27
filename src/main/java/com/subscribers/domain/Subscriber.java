package com.subscribers.domain;

import com.subscribers.domain.exceptions.BalanceOutOfRangeException;
import org.hibernate.validator.constraints.Range;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Subscriber {

	private final PhoneNumber phoneNumber;

	private final String name;

	@Range(min=0,max=100000)
	private final int balance;

	private final int decrementRate;

	public Subscriber(
			PhoneNumber phoneNumber,
			String name,
			int balance,
			int decrementRate)
	throws BalanceOutOfRangeException {

		this.phoneNumber = phoneNumber;
		this.name = name;
		this.balance = balance;
		this.decrementRate = decrementRate;
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Subscriber>> constraintViolations = validator.validate(this);

		if(constraintViolations.size() > 0) {
			throw new BalanceOutOfRangeException();
		}		
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

	public int getDecrementRate() {
		return decrementRate;
	}
}
