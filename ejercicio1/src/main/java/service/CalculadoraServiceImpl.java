package service;

import exception.DivisorInvalidoException;
import exception.OperadorInvalidoException;
import exception.ResultadoInvalidoException;
import exception.SustraendoInvalidoException;

public class CalculadoraServiceImpl implements CalculadoraService {

	public int sumar(int a, int b) {
		validarOperador(a);
		validarOperador(b);
		
		long c = (long)a + b;
		
		if (c > Integer.MAX_VALUE)
			throw new ResultadoInvalidoException(c);
			
		return a + b;
	}

	private void validarOperador(int a) {
		if (a < 0)
			throw new OperadorInvalidoException();
	}

	public int restar(int a, int b) {
		validarOperador(a);
		validarOperador(b);
		
		if (b > a)
			throw new SustraendoInvalidoException();

		return a - b;
	}

	public int multiplicar(int a, int b) {
		validarOperador(a);
		validarOperador(b);
		
		long c = (long)a * b;
		
		if (c > Integer.MAX_VALUE)
			throw new ResultadoInvalidoException(c);
		
		return a * b;
	}

	public int dividir(int a, int b) {
		validarOperador(a);
		validarOperador(b);
		
		if (b == 0)
			throw new DivisorInvalidoException();
		if (a % b != 0)
			throw new ResultadoInvalidoException(a % b);

		return a / b;
	}

}
