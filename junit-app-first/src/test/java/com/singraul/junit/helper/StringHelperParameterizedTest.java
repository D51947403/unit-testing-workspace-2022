package com.singraul.junit.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

	StringHelper helper = new StringHelper();

	private String input;
	private String expectedOutput;

	public StringHelperParameterizedTest(String input, String expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<String[]> getParameters() {

		String[][] testParam = { { "AACD", "CD" }, { "ABFN", "BFN" }, 
				{ "AKL", "KL" },{"SDA","DA"} };

		return Arrays.asList(testParam);
	}

	@Test
	public void testTruncateAInFirst2Positions() {

		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}

}
