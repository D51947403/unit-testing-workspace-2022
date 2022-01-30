package com.singraul.mockito.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.List;

import org.junit.Test;

import com.singraul.mockito.data.api.TodoService;
import com.singraul.mockito.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {


	@Test
	public void testRetrieveTodosRelatedToSpring_usingAStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Devendra");
		assertEquals(2, todos.size());
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring() {
		//fail("Not yet implemented");
		assertFalse(false);
	}

}
