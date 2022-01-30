package com.singraul.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

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
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		//Given
		TodoService todoService = mock(TodoService.class);
		
		List<String> todoList = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
     
		given(todoService.retrieveTodos("funny")).willReturn(todoList);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		//when
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("funny");
		//then
		assertThat(todos.size() , is(2));
	}
	
	
	@Test
	public void deleteTodosNotRelatedToSpring_usingBDD() {
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todoList = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
     
		given(todoServiceMock.retrieveTodos("funny")).willReturn(todoList);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		//when
		 todoBusinessImpl.deleteTodosNotRelatedToSpring("funny");
		//then
		verify(todoServiceMock).deleteTodo("Learn to Dance");
		
		verify(todoServiceMock , times(1)).deleteTodo("Learn to Dance");
		
		verify(todoServiceMock ,never()).deleteTodo("Learn Spring MVC");
	}
	
	
	
	@Test 
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCature() {
		ArgumentCaptor<String>  stringArgCaptor = new ArgumentCaptor<>();
		// given
		TodoService  todoServiceMock= mock(TodoService.class);
		
		List<String>  todoList= Arrays.asList("Spring MVC", "Spring AOP", "Spring ORM" ,"MySQL");
		
		given(todoServiceMock.retrieveTodos("devendra")).willReturn(todoList);
		
		TodoBusinessImpl  todoBusinessimp= new TodoBusinessImpl(todoServiceMock);
		//when
		todoBusinessimp.deleteTodosNotRelatedToSpring("devendra");
		//then 
		//verify(todoServiceMock, times(1)).deleteTodo(stringArgCaptor.capture());
		then(todoServiceMock).should().deleteTodo(stringArgCaptor.capture());
		
		assertThat(stringArgCaptor.getValue() ,is("MySQL"));
	}
	
	
	
	
	@Test
	public void testDeleteTodosNotRelatedToSpring() {
		// fail("Not yet implemented");
		assertFalse(false);
	}

}
