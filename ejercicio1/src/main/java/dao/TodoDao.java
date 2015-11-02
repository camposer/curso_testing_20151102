package dao;

import java.util.List;

import model.Todo;

public interface TodoDao {
	void agregar(Todo t);
	void modificar(Todo t);
	void eliminar(Integer id);
	Todo obtener(Integer id);
	List<Todo> obtenerTodos();
}
