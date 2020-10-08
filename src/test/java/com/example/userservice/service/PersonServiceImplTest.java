package com.example.userservice.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.userserviceapi.service.PersonService;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTest {
	
	@Mock
	PersonService myService;

	//@Before
	public void init() {
		myService = Mockito.mock(PersonService.class);

	}

	@Test
	public void when_greet_is_ok() {
		assertEquals("Hell, World", myService.greet());
	}

	//@Test
	public void test_JUnit() {
		System.out.println("This is the testcase in this class");
		String str1 = "This is the testcase in this class";
		assertEquals("This is the testcase in this class", str1);
	}

}
