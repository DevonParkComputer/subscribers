package com.subscribers.app;

import com.subscribers.business.SubscriberService;
import com.subscribers.domain.PhoneNumber;
import com.subscribers.domain.dao.SubscriberDao;
import com.subscribers.domain.dao.exceptions.SubscriberAlreadyExistsException;
import com.subscribers.domain.dao.exceptions.SubscriberNotFoundException;
import com.subscribers.domain.exceptions.PhoneNumberValidationException;

public class SubscribersApp {

		public static void main(String[] args) {

			SubscriberService subscriberService = new SubscriberService();
			PhoneNumber phoneNumber = null;

			System.out.println("#sz00: " + new SubscriberDao().getSize());

			try {
				phoneNumber = new PhoneNumber("0123456789");
				subscriberService.addSubscriber(phoneNumber,"amcii",900,0.2);

				System.out.println("#sz01: " + new SubscriberDao().getSize() + " " + new SubscriberDao().find(phoneNumber).getPhoneNumber().getDigits());
			}
			catch(SubscriberAlreadyExistsException saee) {}
			catch(SubscriberNotFoundException snfe) {}
			catch(PhoneNumberValidationException pnve) {
				System.out.println(pnve.getMessage());
				System.out.println("#szX0: " + new SubscriberDao().getSize());
				System.out.println("#valid: " + phoneNumber.getDigits());
			}

			try {
				phoneNumber = new PhoneNumber("123456789");
				subscriberService.addSubscriber(phoneNumber,"amcii",900,0.2);

				System.out.println("#sz02: " + new SubscriberDao().getSize() + " " + new SubscriberDao().find(phoneNumber).getPhoneNumber().getDigits());
			}
			catch(SubscriberAlreadyExistsException saee) {}
			catch(SubscriberNotFoundException snfe) {}
			catch(PhoneNumberValidationException pnve) {
				System.out.println(pnve.getMessage());
				System.out.println("#szX1: " + new SubscriberDao().getSize());
				System.out.println("#valid: " + phoneNumber.getDigits());
			}

			try {
				phoneNumber = new PhoneNumber("2345678901");
				subscriberService.addSubscriber(phoneNumber,"amcii",900,0.2);

				System.out.println("#sz03: " + new SubscriberDao().getSize() + " " + new SubscriberDao().find(phoneNumber).getPhoneNumber().getDigits());
			}
			catch(SubscriberAlreadyExistsException saee) {}
			catch(SubscriberNotFoundException snfe) {}
			catch(PhoneNumberValidationException pnve) {
				System.out.println(pnve.getMessage());
				System.out.println("#szX2: " + new SubscriberDao().getSize());
				System.out.println("#valid: " + phoneNumber.getDigits());
			}
	}
}
