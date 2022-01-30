package com.singraul.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void testListSizeMethod() {

		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(3);
		assertEquals(3, mockList.size());
	}

	@Test
	public void testListSizeMethod_multipleValues() {

		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(3).thenReturn(4).thenReturn(0);
		assertEquals(3, mockList.size());
		assertEquals(4, mockList.size());
		assertEquals(0, mockList.size());
	}

	@Test
	public void testListGetMethod() {
		List mockList = mock(List.class);
		when(mockList.get(0)).thenReturn("Devendra");
		assertEquals("Devendra", mockList.get(0));
		assertEquals(null, mockList.get(1));
	}

	@Test
	public void testListGetMethod_argumentMatcher() {
		List mockList = mock(List.class);
		when(mockList.get(anyInt())).thenReturn("Devendra");
		assertEquals("Devendra", mockList.get(0));
		assertEquals("Devendra", mockList.get(1));
		assertEquals("Devendra", mockList.get(5));
		assertEquals("Devendra", mockList.get(19));
	}

	@Test(expected=RuntimeException.class)
	public void testList_throwException() {
		List mockList = mock(List.class);
		when(mockList.get(anyInt())).thenThrow(new RuntimeException("Custom Runtime exception"));
		mockList.get(7);
	}
	
	// BDD= Business Driven Development 
	@Test
	public void testListGetMethod_usingBDD() {
		//Given
		List<String> mockList = mock(List.class);
	
		given(mockList.get(0)).willReturn("Devendra");
		//When 
		String firstElement=mockList.get(0);
		//then
		assertThat(firstElement , is("Devendra"));
		
	}
}
