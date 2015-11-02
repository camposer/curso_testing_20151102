package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Basico {
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Antes de la clase");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Después de la clase");
	}

	@Before
	public void before() {
		System.out.println("Antes del test");
	}

	@After
	public void after() {
		System.out.println("Después del test");
	}

	@Test
	public void sumar() {
		assertEquals(2, 2);
	}
	
	@Test
	public void restar() {
		assertEquals(2, 2);
	}
}
