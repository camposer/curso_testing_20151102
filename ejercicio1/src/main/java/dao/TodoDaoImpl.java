package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import model.Todo;

@Repository
public class TodoDaoImpl implements TodoDao {
	@PersistenceContext
	private EntityManager entityManager;

	public void agregar(Todo t) {
		entityManager.persist(t);
	}

	public void modificar(Todo t) {
		entityManager.merge(t);
	}

	public void eliminar(Integer id) {
		Todo t = obtener(id);
		entityManager.remove(t);
	}

	public Todo obtener(Integer id) {
		return entityManager.find(Todo.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Todo> obtenerTodos() {
		return entityManager.createNamedQuery("Todo.findAll")
				.getResultList();
	}

}
