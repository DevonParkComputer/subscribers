package com.subscribers.app;

import com.subscribers.business.SubscriberService;
import com.subscribers.domain.PhoneNumber;
import com.subscribers.domain.dao.exceptions.SubscriberAlreadyExistsException;
import com.subscribers.domain.exceptions.BalanceOutOfRangeException;
import com.subscribers.domain.exceptions.PhoneNumberException;

public class SubscribersApp {

	//todo: add logging
	public static void main(String[] args) {

		SubscriberService subscriberService = new SubscriberService();
		PhoneNumber phoneNumber = null;

		//PhoneNumberException due to alpha character
		try {
			phoneNumber = new PhoneNumber("A123456789");
			subscriberService.addSubscriber(phoneNumber,"amcii",900,0.2);
		}
		catch(SubscriberAlreadyExistsException saee) {
			System.out.println(saee.getMessage());
		}
		catch(BalanceOutOfRangeException boore) {
			System.out.println(boore.getMessage());
		}
		catch(PhoneNumberException pnve) {
			System.out.println(pnve.getMessage());
		}

		//PhoneNumberException due to short length
		try {
			phoneNumber = new PhoneNumber("123456789");
			subscriberService.addSubscriber(phoneNumber,"amcii",900,0.2);
		}
		catch(SubscriberAlreadyExistsException saee) {
			System.out.println(saee.getMessage());
		}
		catch(BalanceOutOfRangeException boore) {
			System.out.println(boore.getMessage());
		}
		catch(PhoneNumberException pnve) {
			System.out.println(pnve.getMessage());
		}

		//PhoneNumberException due to long length
		try {
			phoneNumber = new PhoneNumber("01234567890");
			subscriberService.addSubscriber(phoneNumber,"amcii",900,0.2);
		}
		catch(SubscriberAlreadyExistsException saee) {
			System.out.println(saee.getMessage());
		}
		catch(BalanceOutOfRangeException boore) {
			System.out.println(boore.getMessage());
		}
		catch(PhoneNumberException pnve) {
			System.out.println(pnve.getMessage());
		}

		//Valid entry
		try {
			phoneNumber = new PhoneNumber("0123456789");
			subscriberService.addSubscriber(phoneNumber,"amcii",900,0.2);
			System.out.println("Subscriber: " + phoneNumber);
		}
		catch(SubscriberAlreadyExistsException saee) {
			System.out.println(saee.getMessage());
		}
		catch(BalanceOutOfRangeException boore) {
			System.out.println(boore.getMessage());
		}
		catch(PhoneNumberException pnve) {
			System.out.println(pnve.getMessage());
		}

		//SubscriberAlreadyExists exception
		try {
			phoneNumber = new PhoneNumber("0123456789");
			subscriberService.addSubscriber(phoneNumber,"amcii",900,0.2);
			System.out.println("Subscriber: " + phoneNumber);
		}
		catch(SubscriberAlreadyExistsException saee) {
			System.out.println(saee.getMessage());
		}
		catch(BalanceOutOfRangeException boore) {
			System.out.println(boore.getMessage());
		}
		catch(PhoneNumberException pnve) {
			System.out.println(pnve.getMessage());
		}


	}
}