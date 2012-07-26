package com.subscribers.business;

import com.subscribers.domain.dao.SubscriberDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class SubscriberServiceTest {

	@Mock private SubscriberDao subscriberDao;

	@Before
	public void setUp() {}

	@Test
	public void shouldAddSubscriber() {
		assertTrue(true);
	}
}
