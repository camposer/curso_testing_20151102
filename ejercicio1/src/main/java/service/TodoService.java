package service;

import java.util.List;

import model.Todo;

public interface TodoService {
	void agregarTodo(Todo t);
	void modificarTodo(Todo t);
	void eliminarTodo(Integer id);
	Todo obtenerTodo(Integer id);
	List<Todo> obtenerTodos();
}
