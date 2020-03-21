package br.com.pizzaria.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pizzaria.excecoes.IngredienteInvalidoException;
import br.com.pizzaria.modelo.entidades.Pizza;
import br.com.pizzaria.modelo.enums.CategoriaIngredientes;
import br.com.pizzaria.modelo.enums.CategoriaPizza;
import br.com.pizzaria.modelo.repositorios.PizzaRepositorio;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private PizzaRepositorio pizzaRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listarPizzas(Model model) {
		model.addAttribute("pizzas", pizzaRepositorio.findAll());
		model.addAttribute("categorias", CategoriaPizza.values());
		model.addAttribute("ingredientes", CategoriaIngredientes.values());
		return "pizza/listagem";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarPizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			throw new IngredienteInvalidoException();
		} else {
			pizzaRepositorio.save(pizza);
		}
		
		model.addAttribute("pizzas", pizzaRepositorio.findAll());
		model.addAttribute("categorias", CategoriaPizza.values());
		return "pizza/tabela-pizzas";
	}

	@RequestMapping("/quantas")
	@ResponseBody
	public String quantasPizzas() {
		return "Atualmente há " + pizzaRepositorio.count() + " cadastradas!";
	}
}
