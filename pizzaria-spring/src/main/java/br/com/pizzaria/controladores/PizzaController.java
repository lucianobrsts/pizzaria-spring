package br.com.pizzaria.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pizzaria.excecoes.IngredienteInvalidoException;
import br.com.pizzaria.modelo.entidades.Ingrediente;
import br.com.pizzaria.modelo.entidades.Pizza;
import br.com.pizzaria.modelo.enums.CategoriaIngredientes;
import br.com.pizzaria.modelo.enums.CategoriaPizza;
import br.com.pizzaria.modelo.repositorios.IngredienteRepositorio;
import br.com.pizzaria.modelo.repositorios.PizzaRepositorio;
import br.com.pizzaria.porpertyeditors.IngredientePropertyEditor;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private IngredientePropertyEditor ingredientePropertyEditor;

	@Autowired
	private PizzaRepositorio pizzaRepositorio;
	@Autowired
	private IngredienteRepositorio ingredienteRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listarPizzas(Model model) {
		model.addAttribute("pizzas", pizzaRepositorio.findAll());
		model.addAttribute("categorias", CategoriaPizza.values());
		model.addAttribute("ingredientes", CategoriaIngredientes.values());
		model.addAttribute("ingredientes", ingredienteRepositorio.findAll());
		return "pizza/listagem";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarPizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			throw new IngredienteInvalidoException();
		} else {
			pizzaRepositorio.save(pizza);
		}

		model.addAttribute("pizzas", pizzaRepositorio.findAll());
		return "pizza/tabela-pizzas";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{pizzaId}")
	public ResponseEntity<String> deletarPizza(@PathVariable Long pizzaId) {
		try {
			pizzaRepositorio.delete(pizzaId);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping("/quantas")
	@ResponseBody
	public String quantasPizzas() {
		return "Atualmente há " + pizzaRepositorio.count() + " cadastradas!";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Ingrediente.class, ingredientePropertyEditor);
	}
}
