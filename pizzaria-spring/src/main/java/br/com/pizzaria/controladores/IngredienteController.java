package br.com.pizzaria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {

	@RequestMapping(method = RequestMethod.GET)
	public String listarIngredientes() {

		return "ingrediente/listagem";
	}

}
