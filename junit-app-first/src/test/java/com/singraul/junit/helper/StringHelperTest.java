package com.singraul.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	StringHelper helper = new StringHelper();

	@Test
	public void testTruncateAInFirst2Positions_AInfirst2Position() {
		String actual = helper.truncateAInFirst2Positions("AACD");
		assertEquals("CD", actual);
	}

	@Test
	public void testTruncateAInFirst2Positions_AInfirstPosition() {
		assertEquals("BCD", helper.truncateAInFirst2Positions("ABCD"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_positive1() {
	 assertEquals(true, helper.areFirstAndLastTwoCharactersTheSame("DEVDE")); 
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_positive2() {
	 assertTrue( helper.areFirstAndLastTwoCharactersTheSame("DEVDE"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_negative1() {
	 assertFalse( helper.areFirstAndLastTwoCharactersTheSame("DEVENDRA"));
	}

	// Sample test case
	@Test
	public void testEqualString() {
		// assertEquals(expected, actual);
		assertEquals("Devendra", "Devendra");
	}
}
