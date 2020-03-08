package br.com.pizzaria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pizzaria.modelo.repositorios.PizzaRepositorio;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private PizzaRepositorio pizzaRepositorio;

	@RequestMapping("/quantas")
	@ResponseBody
	public String quantasPizzas() {
		return "Atualmente h� " + pizzaRepositorio.count() + " cadastradas!";
	}
}
