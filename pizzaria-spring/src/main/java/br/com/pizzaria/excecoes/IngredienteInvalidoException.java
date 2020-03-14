package br.com.pizzaria.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IngredienteInvalidoException extends RuntimeException {

	private static final long serialVersionUID = -5869271780980708319L;

}
