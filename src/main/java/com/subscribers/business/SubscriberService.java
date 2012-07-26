package com.subscribers.business;

import com.subscribers.domain.PhoneNumber;
import com.subscribers.domain.Subscriber;
import com.subscribers.domain.builders.SubscriberBuilder;
import com.subscribers.domain.dao.SubscriberDao;
import com.subscribers.domain.dao.exceptions.SubscriberAlreadyExistsException;
import com.subscribers.domain.dao.exceptions.SubscriberNotFoundException;

public class SubscriberService {

	private SubscriberDao subscriberDao;

	public SubscriberService() {

		subscriberDao = new SubscriberDao();
	}

	public void addSubscriber(PhoneNumber phoneNumber, String name, int balance, double decrementRate)
	throws SubscriberAlreadyExistsException {

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

	public void updateBalance(PhoneNumber phoneNumber, int balance)
	throws SubscriberNotFoundException, SubscriberAlreadyExistsException {

		Subscriber subscriber = subscriberDao.find(phoneNumber);

		SubscriberBuilder subscriberBuilder = new SubscriberBuilder();
		subscriberBuilder.phoneNumber(phoneNumber);
		subscriberBuilder.name(subscriber.getName());
		subscriberBuilder.balance(balance);
		subscriberBuilder.decrementRate(subscriber.getDecrementRate());
		subscriberDao.update(phoneNumber, subscriberBuilder.build());
	}

	public int retrieveBalance(PhoneNumber phoneNumber)
	throws SubscriberNotFoundException {

		Subscriber subscriber = subscriberDao.find(phoneNumber);
		return subscriber.getBalance();
	}
}
