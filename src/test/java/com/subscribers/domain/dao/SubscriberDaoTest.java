package com.subscribers.domain.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SubscriberDaoTest {

	@Before
	public void setUp() {
		Db.clear();
	}

	@Test
	public void shouldExist() {
		new SubscriberDao();
	}

	@After
	public void tearDown() {
		Db.clear();
	}
}
