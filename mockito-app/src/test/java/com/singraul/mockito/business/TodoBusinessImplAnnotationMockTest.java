package com.singraul.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.singraul.mockito.data.api.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplAnnotationMockTest {

	// @Mock is the replacement of 	
	//TodoService todoService = mock(TodoService.class);
	@Mock
	TodoService todoServiceMock;
	
	//@InjectMock is the replacement of 
	// TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
	@InjectMocks 
	TodoBusinessImpl todoBusinessImpl ;
	
	//@Captor is the replacement of 
	//	ArgumentCaptor<String> stringArgCaptor = new ArgumentCaptor<>();
	@Captor
	ArgumentCaptor<String> stringArgCaptor;
	
	@Test
	public void testRetrieveTodosRelatedToSpring_mockito1() {
		
		List<String> todoList = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		when(todoServiceMock.retrieveTodos("Devendra")).thenReturn(todoList);

		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Devendra");
		assertEquals(2, todos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_mockito2() {
		
		List<String> todoList = Arrays.asList();

		when(todoServiceMock.retrieveTodos("funny")).thenReturn(todoList);

		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("funny");
		assertEquals(0, todos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		// Given

		List<String> todoList = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("funny")).willReturn(todoList);

		// when
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("funny");
		// then
		assertThat(todos.size(), is(2));
	}

	@Test
	public void deleteTodosNotRelatedToSpring_usingBDD() {
		// Given

		List<String> todoList = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("funny")).willReturn(todoList);

		// when
		todoBusinessImpl.deleteTodosNotRelatedToSpring("funny");
		// then
		verify(todoServiceMock).deleteTodo("Learn to Dance");

		verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");

		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCature() {
	
		// given
		List<String> todoList = Arrays.asList("Spring MVC", "Spring AOP", "Spring ORM", "MySQL");

		given(todoServiceMock.retrieveTodos("devendra")).willReturn(todoList);
		// when
		todoBusinessImpl.deleteTodosNotRelatedToSpring("devendra");
		// then
		// verify(todoServiceMock, times(1)).deleteTodo(stringArgCaptor.capture());
		then(todoServiceMock).should().deleteTodo(stringArgCaptor.capture());

		assertThat(stringArgCaptor.getValue(), is("MySQL"));
	}

}
