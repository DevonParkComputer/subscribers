package com.subscribers.domain.dao;

import com.subscribers.domain.PhoneNumber;
import com.subscribers.domain.Subscriber;
import com.subscribers.domain.dao.exceptions.SubscriberAlreadyExistsException;
import com.subscribers.domain.dao.exceptions.SubscriberNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Db {

	private static Map<PhoneNumber,Subscriber> subscribers = new HashMap<PhoneNumber,Subscriber>();

	static void put(Subscriber subscriber)
	throws SubscriberAlreadyExistsException {

		if(subscribers.containsKey(subscriber.getPhoneNumber())) {
			throw new SubscriberAlreadyExistsException();
		}
		else {
			subscribers.put(subscriber.getPhoneNumber(), subscriber);
		}
	}

	static Subscriber get(PhoneNumber phoneNumber)
	throws SubscriberNotFoundException {

		if(subscribers.containsKey(phoneNumber)) return subscribers.get(phoneNumber);

		throw new SubscriberNotFoundException();
	}

	static Subscriber remove(PhoneNumber phoneNumber)
	throws SubscriberNotFoundException {

		if(subscribers.containsKey(phoneNumber)) subscribers.remove(phoneNumber);

		throw new SubscriberNotFoundException();
	}

	static void clear() {
		subscribers.clear();
	}
}