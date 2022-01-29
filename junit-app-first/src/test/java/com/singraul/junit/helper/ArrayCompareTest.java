package com.singraul.junit.helper;

import static org.junit.Assert.*;

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

}
