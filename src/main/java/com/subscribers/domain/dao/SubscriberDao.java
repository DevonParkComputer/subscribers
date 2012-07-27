package com.subscribers.domain.dao;

import com.subscribers.domain.PhoneNumber;
import com.subscribers.domain.Subscriber;
import com.subscribers.domain.dao.exceptions.SubscriberAlreadyExistsException;
import com.subscribers.domain.dao.exceptions.SubscriberNotFoundException;

import java.util.Collection;

public class SubscriberDao {

	public void create(Subscriber subscriber)
	throws SubscriberAlreadyExistsException {

		try {
			if(Db.get(subscriber.getPhoneNumber()) != null) {
				throw new SubscriberAlreadyExistsException();
			}
		}
		catch(SubscriberNotFoundException e) {
			Db.put(subscriber);
		}
	}

	public Collection<Subscriber> findAll() {

		return Db.getSubscribers();
	}

	public Subscriber find(PhoneNumber phoneNumber)
	throws SubscriberNotFoundException {

		return Db.get(phoneNumber);
	}

	public void update(PhoneNumber phoneNumber, Subscriber subscriber)
	throws SubscriberNotFoundException {

		if(Db.get(phoneNumber) != null) Db.put(subscriber);
	}

	public void delete(PhoneNumber phoneNumber)
	throws SubscriberNotFoundException {

		Db.remove(phoneNumber);
	}

	public int getSize() {

		return Db.size();
	}

	public void clear() {

		Db.clear();
	}
}
