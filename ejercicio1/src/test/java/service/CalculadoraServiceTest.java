package service;

import org.junit.Assert;
import org.junit.Test;

import exception.DivisorInvalidoException;
import exception.OperadorInvalidoException;
import exception.ResultadoInvalidoException;
import exception.SustraendoInvalidoException;

public class CalculadoraServiceTest {
	private CalculadoraService calculadoraService;
	
	public CalculadoraServiceTest() {
		calculadoraService = CalculadoraServiceFactory
				.createCalculadoraService();
	}
	
	@Test
	public void sumar() {
		Assert.assertEquals(4, calculadoraService.sumar(2, 2));
	}

	@Test
	public void operadorInvalido() {
		try {
			calculadoraService.sumar(-2, 2);
			Assert.fail();
			calculadoraService.sumar(2, -2);
			Assert.fail();
		} catch (OperadorInvalidoException oie) {
			Assert.assertTrue(true);
		}
	}

	@Test(expected = ResultadoInvalidoException.class)
	public void sumarResultadoInvalido() {
		calculadoraService.sumar(Integer.MAX_VALUE, 1);
	}

	@Test
	public void restar() {
		Assert.assertEquals(2, calculadoraService.restar(4, 2));
	}

	@Test(expected = SustraendoInvalidoException.class)
	public void restarSustraendoInvalido() {
		calculadoraService.restar(4, 6);
	}

	@Test
	public void multiplicar() {
		Assert.assertEquals(6, calculadoraService.multiplicar(3, 2));
	}

	@Test(expected = ResultadoInvalidoException.class)
	public void multiplicarResultadoInvalido() {
		calculadoraService.multiplicar(Integer.MAX_VALUE, 2);
	}

	@Test
	public void dividir() {
		Assert.assertEquals(2, calculadoraService.dividir(4, 2));
	}

	@Test(expected = ResultadoInvalidoException.class)
	public void dividirResultadoInvalido() {
		calculadoraService.dividir(4, 3);
	}

	@Test(expected = DivisorInvalidoException.class)
	public void dividirDivisorInvalido() {
		calculadoraService.dividir(4, 0);
	}
}
