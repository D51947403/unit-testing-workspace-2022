package com.singraul.mockito.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.singraul.mockito.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_mockito1() {
		TodoService todoService = mock(TodoService.class);
		List<String> todoList = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("Devendra")).thenReturn(todoList);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Devendra");
		assertEquals(2, todos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_mockito2() {
		TodoService todoService = mock(TodoService.class);
		List<String> todoList = Arrays.asList();

		when(todoService.retrieveTodos("funny")).thenReturn(todoList);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("funny");
		assertEquals(0, todos.size());
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring() {
		// fail("Not yet implemented");
		assertFalse(false);
	}

}
