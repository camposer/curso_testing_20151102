package dao;

import java.util.Date;

import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import config.DatabaseConfig;
import model.Todo;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration
@Transactional
public class TodoDaoTest {
	@Autowired
	private TodoDao todoDao;
	private Todo t;

	@Before
	public void setUp() {
		t = new Todo();
		t.setTitulo("Título");
		t.setDescripcion("Descripción");
		t.setFecha(new Date());
		t.setEstatus(1);
		
		todoDao.agregar(t);
	}
	
	@Test
	public void agregar() {
		Todo t1 = new Todo();
		t1.setTitulo("Título");
		t1.setDescripcion("Descripción");
		t1.setFecha(new Date());
		t1.setEstatus(1);
		
		todoDao.agregar(t1);

		Assert.assertNotNull(t1.getId());
	}
	
	@Test
	public void modificar() {
		String titulo = "Título XXX";
		String descripcion = "Descripción XXX";
		Date fecha = new Date();
		int estatus = 1;
		
		t.setTitulo(titulo);
		t.setDescripcion(descripcion);
		t.setFecha(fecha);
		t.setEstatus(estatus);
		
		todoDao.modificar(t);
		
		Todo t1 = todoDao.obtener(t.getId());

		Assert.assertEquals(t.getId(), t1.getId());
		Assert.assertEquals(t.getTitulo(), t1.getTitulo());
		Assert.assertEquals(t.getDescripcion(), t1.getDescripcion());
		Assert.assertEquals(t.getFecha(), t1.getFecha());
		Assert.assertEquals(t.getEstatus(), t1.getEstatus());
	}

	@Test
	public void eliminar() {
		int numeroTodos = todoDao.obtenerTodos().size();
		todoDao.eliminar(t.getId());
		Assert.assertEquals(numeroTodos - 1, todoDao.obtenerTodos().size());
	}
	
	@Test
	public void obtenerTodos() {
		Assert.assertEquals(1, todoDao.obtenerTodos().size());
	}
	
	@Configuration
	@ComponentScan(
			basePackageClasses = DatabaseConfig.class,
			basePackages = "dao"
		)
	public static class Config {

	}
}
