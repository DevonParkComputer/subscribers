package com.subscribers.domain.dao;

import com.subscribers.domain.PhoneNumber;
import com.subscribers.domain.Subscriber;
import com.subscribers.domain.dao.exceptions.SubscriberAlreadyExistsException;
import com.subscribers.domain.dao.exceptions.SubscriberNotFoundException;

public class SubscriberDao {

	public void create(Subscriber subscriber)
	throws SubscriberAlreadyExistsException {

		Db.put(subscriber);
	}

	public Subscriber find(PhoneNumber phoneNumber)
	throws SubscriberNotFoundException {

		return Db.get(phoneNumber);
	}

	public void update(PhoneNumber phoneNumber, Subscriber subscriber)
	throws SubscriberNotFoundException, SubscriberAlreadyExistsException {

		if(Db.get(phoneNumber) != null) Db.put(subscriber);
	}

	public void delete(PhoneNumber phoneNumber)
	throws SubscriberNotFoundException {

		Db.remove(phoneNumber);
	}

	public void clear() {
		Db.clear();
	}
}
