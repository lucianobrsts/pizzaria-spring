<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<fmt:setLocale value="pt_BR" />
<table
	class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr>
			<th style="width: 10%; text-align: center">#</th>
			<th style="width: 30%; text-align: center">Nome</th>
			<th style="width: 20%; text-align: center">Preço</th>
			<th style="width: 10%; text-align: center">Categoria</th>
			<th style="width: 10%; text-align: center">Ingredientes</th>
			<th style="width: 10%; text-align: center">Editar</th>
			<th style="width: 10%; text-align: center">Deletar</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${pizzas}" var="pizza">
			<tr data-id="${pizza.id}">
				<td style="text-align: center;">${pizza.id}</td>
				
				<td>${pizza.nome}</td>
				
				<td style="text-align: center;">
					<fmt:formatNumber value="${pizza.preco}" type="currency" />
				</td>
				
				<td style="text-align: center;">${pizza.categoria}</td>
				
				<td style="text-align: center;">
				<c:forEach items="${pizza.ingredientes}" var="ingrediente">
					${ingrediente.nome} <br />
				</c:forEach>
				</td>
				
				<td style="text-align: center;"><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td style="text-align: center;"><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">Pizzas Cadastradas: <span id="quantidade-pizzas"> ${pizzas.size()} </span></td>
		</tr>
		<tr>
			<td colspan="7">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-pizza">Cadastrar Pizzas</button>
			</td>
		</tr>
	</tfoot>
</table>