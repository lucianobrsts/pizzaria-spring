<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<table
	class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr>
			<th style="width: 10%; text-align: center">#</th>
			<th style="width: 45%; text-align: center">Nome</th>
			<th style="width: 30%; text-align: center">Categoria</th>
			<th style="width: 8%; text-align: center">Editar</th>
			<th style="width: 8%; text-align: center">Deletar</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${ingredientes}" var="ingrediente">
			<tr data-id="${ingrediente.id}">
				<td style="text-align: center;">${ingrediente.id}</td>
				<td>${ingrediente.nome}</td>
				<td style="text-align: center;">${ingrediente.categoria}</td>
				<td style="text-align: center;"><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td style="text-align: center;"><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">Ingredientes Cadastrados: <span id="quantidade-ingredientes"> ${ingredientes.size()} </span></td>
		</tr>
		<tr>
			<td colspan="5">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-ingrediente">Cadastrar Ingredientes</button>
			</td>
		</tr>
	</tfoot>
</table>