package com.subscribers.domain;

import com.subscribers.domain.exceptions.BalanceOutOfRangeException;
import com.subscribers.domain.exceptions.PhoneNumberException;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SubscriberValidationTest {

	@Test
	public void shouldNotHaveBalanceLessThanZeroCents() {
		try {
			new Subscriber(new PhoneNumber("0123456789"),"name",-1,0.08);

			assertTrue(false);
		}
		catch(BalanceOutOfRangeException boore) {
			assertTrue(true);
		}
		catch (PhoneNumberException pne) {
			assertTrue(false);
		}
	}

	@Test
	public void shouldNotHaveBalanceMoreThanOneHundredThousandCents() {
		try {
			new Subscriber(new PhoneNumber("0123456789"),"name",100001,0.08);
			assertTrue(false);
		}
		catch(BalanceOutOfRangeException boore) {
			assertTrue(true);
		}
		catch (PhoneNumberException pne) {
			assertTrue(false);
		}
	}
}
