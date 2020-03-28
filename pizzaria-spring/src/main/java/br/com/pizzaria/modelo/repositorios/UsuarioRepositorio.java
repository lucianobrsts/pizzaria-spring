package br.com.pizzaria.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.modelo.entidades.Pizzaria;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Pizzaria, Long>{

	public Pizzaria findOneByLogin(String login);

}
