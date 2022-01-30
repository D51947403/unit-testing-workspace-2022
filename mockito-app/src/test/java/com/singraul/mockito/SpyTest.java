package com.singraul.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
// Spy is partial mock.
// creating partially real object and partially mocking object
//its not recommended in real time application unless legacy class testing requirement 
// are not there in project
public class SpyTest {

	@Test
	public void test() {
		List arryListSpy=spy(ArrayList.class);
		assertEquals(0, arryListSpy.size());
		arryListSpy.add("Dummy" );
		arryListSpy.add("Funny");
		// updated actual object size
		assertEquals(2, arryListSpy.size());
	}

}
