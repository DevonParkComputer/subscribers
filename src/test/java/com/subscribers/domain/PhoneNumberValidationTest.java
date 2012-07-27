package com.subscribers.domain;

import com.subscribers.domain.exceptions.PhoneNumberException;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberValidationTest {
	
	@Test
	public void shouldNotHaveLessThanTenCharacters() {
		try {
			new PhoneNumber("123456789");
			assertTrue(false);
		}
		catch (PhoneNumberException e) {
			assertTrue(true);
		}
	}

	@Test
	public void shouldNotHaveMoreThanTenCharacters() {
		try {
			new PhoneNumber("01234567890");
			assertTrue(false);
		}
		catch (PhoneNumberException e) {
			assertTrue(true);
		}
	}

	@Test
	public void shouldHaveOnlyNumericCharacters() {
		try {
			new PhoneNumber("aA345-6790");
			assertTrue(false);
		}
		catch (PhoneNumberException e) {
			assertTrue(true);
		}
	}
}
