package com.subscribers.domain;

import com.subscribers.domain.exceptions.PhoneNumberException;
import org.hibernate.validator.constraints.Length;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class PhoneNumber {

	@Length(min=10,max=10)
	@Pattern(regexp="^(\\d)*$")
	private final String digits;

	public PhoneNumber(String digits)
	throws PhoneNumberException {

		this.digits = digits;

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<PhoneNumber>> constraintViolations = validator.validate(this);

		if(constraintViolations.size() > 0) {
			throw new PhoneNumberException();
		}
	}

	public String getDigits() {
		return digits;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PhoneNumber that = (PhoneNumber) o;

		if (digits != null ? !digits.equals(that.digits) : that.digits != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return digits != null ? digits.hashCode() : 0;
	}
}
