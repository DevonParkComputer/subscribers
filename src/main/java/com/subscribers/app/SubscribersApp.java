package com.subscribers.app;

import com.subscribers.business.SubscriberService;
import com.subscribers.domain.PhoneNumber;
import com.subscribers.domain.Subscriber;
import com.subscribers.domain.dao.exceptions.SubscriberAlreadyExistsException;
import com.subscribers.domain.dao.exceptions.SubscriberNotFoundException;
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
			subscriberService.addSubscriber(phoneNumber,"amcii",900,100);
			System.out.println("Subscriber added: " + phoneNumber.getDigits());
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
			subscriberService.addSubscriber(phoneNumber,"amcii",900,100);
			System.out.println("Subscriber added: " + phoneNumber.getDigits());
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
			subscriberService.addSubscriber(phoneNumber,"amcii",900,100);
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
			subscriberService.addSubscriber(phoneNumber,"amcii",992,100);
			System.out.println("Subscriber added: " + phoneNumber.getDigits());
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
			subscriberService.addSubscriber(phoneNumber,"amcii",900,100);
			System.out.println("Subscriber added: " + phoneNumber.getDigits());
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

		//Valid balance at construction
		try {
			phoneNumber = new PhoneNumber("1234567890");
			int balance = 50000;
			subscriberService.addSubscriber(phoneNumber,"amcii",balance,100);
			System.out.println("Subscriber added: " + phoneNumber.getDigits());
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

		//Large balance at construction
		try {
			phoneNumber = new PhoneNumber("2345678901");
			int balance = 100001;
			subscriberService.addSubscriber(phoneNumber,"amcii",balance,100);
			System.out.println("Subscriber added: " + phoneNumber.getDigits());
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

		//Negative balance at construction
		try {
			phoneNumber = new PhoneNumber("2345678901");
			int balance = -1;
			subscriberService.addSubscriber(phoneNumber,"amcii",balance,100);
			System.out.println("Subscriber added: " + phoneNumber.getDigits());
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

		//Valid remove
		try {
			phoneNumber = new PhoneNumber("1234567890");
			subscriberService.removeSubscriber(phoneNumber);
			System.out.println("Subscriber removed: " + phoneNumber.getDigits());
		}
		catch(PhoneNumberException pnve) {
			System.out.println(pnve.getMessage());
		}
		catch(SubscriberNotFoundException e) {
			System.out.println(e.getMessage());
		}

		//SubscriberNotFound exception when attempting to remove
		try {
			phoneNumber = new PhoneNumber("1234567890");
			subscriberService.removeSubscriber(phoneNumber);
			System.out.println("Subscriber removed: " + phoneNumber.getDigits());
		}
		catch(PhoneNumberException pnve) {
			System.out.println(pnve.getMessage());
		}
		catch(SubscriberNotFoundException e) {
			System.out.println(e.getMessage());
		}

		//Valid update to Subscriber balance
		try {
			phoneNumber = new PhoneNumber("0123456789");
			subscriberService.updateBalance(phoneNumber, -100);
			System.out.println("Subscriber updated: " + phoneNumber.getDigits());
		}
		catch(PhoneNumberException pnve) {
			System.out.println(pnve.getMessage());
		}
		catch(SubscriberNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(BalanceOutOfRangeException boore) {
			System.out.println(boore.getMessage());
		}

		//Oversized increase to Subscriber balance
		try {
			phoneNumber = new PhoneNumber("0123456789");
			subscriberService.updateBalance(phoneNumber, 100000);
			System.out.println("Subscriber updated: " + phoneNumber.getDigits());
		}
		catch(PhoneNumberException pnve) {
			System.out.println(pnve.getMessage());
		}
		catch(SubscriberNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(BalanceOutOfRangeException boore) {
			System.out.println(boore.getMessage());
		}

		//Oversized decrease to Subscriber balance
		try {
			phoneNumber = new PhoneNumber("0123456789");
			subscriberService.updateBalance(phoneNumber, -100000);
			System.out.println("Subscriber updated: " + phoneNumber.getDigits());
		}
		catch(PhoneNumberException pnve) {
			System.out.println(pnve.getMessage());
		}
		catch(SubscriberNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(BalanceOutOfRangeException boore) {
			System.out.println(boore.getMessage());
		}

		//Valid balance retrieval
		try {
			phoneNumber = new PhoneNumber("0123456789");
			Subscriber subscriber = subscriberService.retrieveSubscriber(phoneNumber);
			//todo: add getMinutesRemaining to business
			System.out.println("Subscriber balance: " + phoneNumber.getDigits()
					+ " ("
					+ subscriber.getBalance()
					+ "¢, "
					+ subscriber.getBalance() / subscriber.getDecrementRate()
					+ " minutes remaining)");
		}
		catch(PhoneNumberException pnve) {
			System.out.println(pnve.getMessage());
		}
		catch(SubscriberNotFoundException e) {
			System.out.println(e.getMessage());
		}

		//SubscriberNotFoundException during balance retrieval
		try {
			phoneNumber = new PhoneNumber("1234567890");
			//todo: add getMinutesRemaining to business
			Subscriber subscriber = subscriberService.retrieveSubscriber(phoneNumber);
			System.out.println("Subscriber balance: " + phoneNumber.getDigits()
													  + " ("
													  + subscriber.getBalance()
													  + "¢, "
													  + subscriber.getBalance() / subscriber.getDecrementRate()
													  + " minutes remaining)");
		}
		catch(PhoneNumberException pnve) {
			System.out.println(pnve.getMessage());
		}
		catch(SubscriberNotFoundException e) {
			System.out.println(e.getMessage());
		}

		new Thread() {
			//todo: add getCurrent accounts to business
		}.run();

	}
}