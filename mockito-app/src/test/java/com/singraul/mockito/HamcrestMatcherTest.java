package com.singraul.mockito;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatcherTest {

	@Test
	public void testHamcrestmethods() {
		// collection
		List<Integer> scoreList = Arrays.asList(102, 115, 214, 56, 72, 190);

		assertThat(scoreList, hasSize(6));
		assertThat(scoreList, hasItem(102));
		assertThat(scoreList, everyItem(greaterThan(14)));
		assertThat(56, isIn(scoreList));
		// String 
		assertThat("" , isEmptyString());
		assertThat(null , isEmptyOrNullString());
		// Array
		Integer [] numArr = {14,18,23,65};
		assertThat(numArr , arrayWithSize(4));
		assertThat(numArr , arrayContaining(14,18,23,65));
		assertThat(numArr , arrayContainingInAnyOrder(14,23,65,18));
	}

}
