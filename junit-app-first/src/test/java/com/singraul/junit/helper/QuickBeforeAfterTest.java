package com.singraul.junit.helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickBeforeAfterTest {

	@Before
	public void setup() {
		System.out.println("before test");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}

	@After
	public void tearDown() {
		System.out.println("After test");
	}
	
}
