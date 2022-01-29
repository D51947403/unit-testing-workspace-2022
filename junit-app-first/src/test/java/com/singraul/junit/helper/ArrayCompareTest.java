package com.singraul.junit.helper;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class ArrayCompareTest {

	@Test
	public void testSortArray_positive() {
	   int[] num= {4,2,5,15};
	   int [] expected= {2,4,5,15};
	   Arrays.sort(num);
	   assertArrayEquals(expected, num);
	   
	}
	
	@Test(expected=NullPointerException.class)
	public void testSortArray_nullArray() {
	   int[] num=null;
	   Arrays.sort(num);
	}
	// here time value in milliseconds 
	@Test(timeout = 100)
	public void testSortArray_performance() {
	   int[] num= {14,17,13,10,0,21};
	   for(int i=0; i< 1000000; i++) {
		   num[0]=i;
		   Arrays.sort(num);
	   }
	}

}
