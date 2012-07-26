package com.subscribers.business;

import com.subscribers.domain.Subscriber;
import com.subscribers.domain.dao.SubscriberDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SubscriberServiceTest {

	@Mock private SubscriberDao subscriberDao;

	@Before
	private void setUp() {}

	@Test
	public void shouldAddSubscriber(Subscriber subscriber) {

	}
}
