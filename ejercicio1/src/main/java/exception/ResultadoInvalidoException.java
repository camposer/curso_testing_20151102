package exception;

import exception.CalculadoraException;

public class ResultadoInvalidoException extends CalculadoraException {
	private static final long serialVersionUID = -6012686062900392579L;
	private long resultado;
	
	public ResultadoInvalidoException(long resultado) {
		this.resultado = resultado;
	}

	public long getResultado() {
		return resultado;
	}

	public void setResultado(long resultado) {
		this.resultado = resultado;
	}
}
