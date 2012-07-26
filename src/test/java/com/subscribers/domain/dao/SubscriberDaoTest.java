package com.subscribers.domain.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SubscriberDaoTest {

	@Before
	private void setUp() {
		Db.clear();
	}

	@After
	private void tearDown() {
		Db.clear();
	}
}
