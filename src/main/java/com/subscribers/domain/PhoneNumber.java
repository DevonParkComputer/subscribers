package com.subscribers.domain;

import com.subscribers.domain.validation.exceptions.PhoneNumberValidationException;
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
	throws PhoneNumberValidationException {

		this.digits = digits;

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<PhoneNumber>> constraintViolations = validator.validate(this);

		if(constraintViolations.size() > 0) {
			throw new PhoneNumberValidationException();
		}
	}

	public String getDigits() {
		return digits;
	}
}
