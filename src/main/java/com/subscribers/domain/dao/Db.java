package com.subscribers.domain.dao;

import com.subscribers.domain.PhoneNumber;
import com.subscribers.domain.Subscriber;
import com.subscribers.domain.dao.exceptions.SubscriberNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Db {

	private static Map<PhoneNumber,Subscriber> subscribers = new HashMap<PhoneNumber,Subscriber>();

	static void put(Subscriber subscriber) {

		subscribers.put(subscriber.getPhoneNumber(), subscriber);
	}

	static Subscriber get(PhoneNumber phoneNumber)
	throws SubscriberNotFoundException {

		if(subscribers.containsKey(phoneNumber)) {
			return subscribers.get(phoneNumber);
		}
		else {
			throw new SubscriberNotFoundException();
		}
	}

	static Collection<Subscriber> getSubscribers() {
		return subscribers.values();
	}

	static void remove(PhoneNumber phoneNumber)
	throws SubscriberNotFoundException {

		if(subscribers.containsKey(phoneNumber)) {
			subscribers.remove(phoneNumber);
		}
		else {
			throw new SubscriberNotFoundException();
		}
	}

	static int size() {
		return subscribers.size();
	}

	static void clear() {
		subscribers.clear();
	}
}