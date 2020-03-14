package br.com.pizzaria.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.pizzaria.excecoes.IngredienteInvalidoException;
import br.com.pizzaria.modelo.entidades.Ingrediente;
import br.com.pizzaria.modelo.enums.CategoriasIngredientes;
import br.com.pizzaria.modelo.repositorios.IngredienteRepositorio;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {

	@Autowired
	private IngredienteRepositorio ingredienteRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listarIngredientes(Model model) {
		Iterable<Ingrediente> ingredientes = ingredienteRepositorio.findAll();

		model.addAttribute("titulo", "Listagem de Ingredientes");
		model.addAttribute("ingredientes", ingredientes);
		model.addAttribute("categorias", CategoriasIngredientes.values());

		return "ingrediente/listagem";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarIngrediente(@Valid @ModelAttribute Ingrediente ingrediente, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			throw new IngredienteInvalidoException();
		} else {
			ingredienteRepositorio.save(ingrediente);
		}

		return "redirect:/app/ingredientes";
	}

}
