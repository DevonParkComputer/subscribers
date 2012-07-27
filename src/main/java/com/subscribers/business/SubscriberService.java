package com.subscribers.business;

import com.subscribers.domain.PhoneNumber;
import com.subscribers.domain.Subscriber;
import com.subscribers.domain.builders.SubscriberBuilder;
import com.subscribers.domain.dao.SubscriberDao;
import com.subscribers.domain.dao.exceptions.SubscriberAlreadyExistsException;
import com.subscribers.domain.dao.exceptions.SubscriberNotFoundException;
import com.subscribers.domain.exceptions.BalanceOutOfRangeException;

import java.util.Collection;

public class SubscriberService {

	private SubscriberDao subscriberDao;

	public SubscriberService() {

		subscriberDao = new SubscriberDao();
	}

	public void addSubscriber(PhoneNumber phoneNumber, String name, int balance, int decrementRate)
	throws SubscriberAlreadyExistsException, BalanceOutOfRangeException {

		SubscriberBuilder subscriberBuilder = new SubscriberBuilder();
		subscriberBuilder.phoneNumber(phoneNumber);
		subscriberBuilder.name(name);
		subscriberBuilder.balance(balance);
		subscriberBuilder.decrementRate(decrementRate);
		Subscriber subscriber = subscriberBuilder.build();

		subscriberDao.create(subscriber);
	}

	public Subscriber retrieveSubscriber(PhoneNumber phoneNumber)
	throws SubscriberNotFoundException {

		return subscriberDao.find(phoneNumber);
	}

	public void removeSubscriber(PhoneNumber phoneNumber)
	throws SubscriberNotFoundException {

		subscriberDao.delete(phoneNumber);
	}

	public void updateBalance(PhoneNumber phoneNumber, int balanceChange)
	throws SubscriberNotFoundException,
		   BalanceOutOfRangeException
	{

		Subscriber subscriber = subscriberDao.find(phoneNumber);

		SubscriberBuilder subscriberBuilder = new SubscriberBuilder();
		subscriberBuilder.phoneNumber(phoneNumber);
		subscriberBuilder.name(subscriber.getName());
		int balance = subscriber.getBalance();
		subscriberBuilder.balance(balance + balanceChange);
		subscriberBuilder.decrementRate(subscriber.getDecrementRate());
		subscriberDao.update(phoneNumber, subscriberBuilder.build());
	}

	public String retrieveBalance(PhoneNumber phoneNumber)
	throws SubscriberNotFoundException {

		Subscriber subscriber = subscriberDao.find(phoneNumber);
		return "Subscriber balance: "
				+ phoneNumber.getDigits()
				+ " ("
				+ subscriber.getBalance()
				+ "¢, "
				+ (subscriber.getBalance() / subscriber.getDecrementRate())
				+ " minutes remaining)";
	}

	public Collection<Subscriber> getCurrentAccounts() {
		return subscriberDao.findAll();
	}
}
