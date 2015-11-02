package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.TodoDao;
import model.Todo;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoDao todoDao;

	public void agregarTodo(Todo t) {
		todoDao.agregar(t);
	}

	public void modificarTodo(Todo t) {
		todoDao.modificar(t);
	}

	public void eliminarTodo(Integer id) {
		todoDao.eliminar(id);
	}

	public Todo obtenerTodo(Integer id) {
		return todoDao.obtener(id);
	}

	public List<Todo> obtenerTodos() {
		return todoDao.obtenerTodos();
	}

}
