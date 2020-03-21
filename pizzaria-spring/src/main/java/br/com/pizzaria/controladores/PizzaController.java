package br.com.pizzaria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pizzaria.modelo.repositorios.PizzaRepositorio;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private PizzaRepositorio pizzaRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listarPizzas(Model model) {
		model.addAttribute("pizzas", pizzaRepositorio.findAll());
		return "pizza/listagem";
	}

	@RequestMapping("/quantas")
	@ResponseBody
	public String quantasPizzas() {
		return "Atualmente há " + pizzaRepositorio.count() + " cadastradas!";
	}
}
