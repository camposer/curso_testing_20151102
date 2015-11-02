package service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.TodoDao;
import dao.TodoDaoDummy;
import model.Todo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ActiveProfiles("test")
public class TodoServiceTest {
	@Autowired
	private TodoService todoService;
	
	@Test
	public void agregar() {
		int numeroTodos = todoService.obtenerTodos().size();
		
		Todo t1 = new Todo();
		t1.setTitulo("Título");
		t1.setDescripcion("Descripción");
		t1.setFecha(new Date());
		t1.setEstatus(1);
		
		todoService.agregarTodo(t1);
		
		Assert.assertEquals(numeroTodos + 1, 
				todoService.obtenerTodos().size());
	}
	
	@Configuration
	@ComponentScan(basePackages = { "service" })
	public static class Config {
		@Bean
		public TodoDao todoDao() {
			return new TodoDaoDummy();
		}
	}
}
