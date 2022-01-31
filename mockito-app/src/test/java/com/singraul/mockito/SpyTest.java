package com.singraul.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

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
		List<String> arryListSpy=spy(ArrayList.class);
		assertEquals(0, arryListSpy.size());
		arryListSpy.add("Dummy" );
		arryListSpy.add("Funny");
		// updated actual object size
		assertEquals(2, arryListSpy.size());
	}

	@Test
	public void creatingASpyOnArrayList() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Ranga");
		listSpy.add("in28Minutes");

		verify(listSpy).add("Ranga");
		verify(listSpy).add("in28Minutes");

		assertEquals(2, listSpy.size());
		assertEquals("Ranga", listSpy.get(0));
	}

	@Test
	public void creatingASpyOnArrayList_overridingSpecificMethods() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Ranga");
		listSpy.add("in28Minutes");

		stub(listSpy.size()).toReturn(-1);

		assertEquals(-1, listSpy.size());
		assertEquals("Ranga", listSpy.get(0));

		// @Spy Annotation
	}

}
