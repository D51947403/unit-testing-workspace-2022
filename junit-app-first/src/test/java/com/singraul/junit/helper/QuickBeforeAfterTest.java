package com.singraul.junit.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {

	// this method must be static 
	@BeforeClass
	public static void setup_beforeClass() {
		System.out.println("before class");
	}
	
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
	
	// this method must be static 
	@AfterClass
	public static void tearDown_afterClass() {
		System.out.println("After class");
	}
	
}
