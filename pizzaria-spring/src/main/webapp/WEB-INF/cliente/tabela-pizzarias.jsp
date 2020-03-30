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
			<th style="width: 30%; text-align: center">Nome</th>
			<th style="width: 40%; text-align: center">Endereço</th>
			<th style="width: 20%; text-align: center">Atendendo desde</th>
			<th style="width: 10%; text-align: center">Entre em Contato</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${pizzarias}" var="pizzaria">
			<tr data-id="${pizzaria.id}">
				<td style="text-align: center;">${pizzaria.nome}</td>
				<td style="text-align: center;">${pizzaria.endereco}</td>
				<td style="text-align: center;"><fmt:formatDate value="${pizzaria.dataCadastro.time}" pattern="dd/MM/yyyy" /></td>
				<td style="text-align: center;"><a href="#">Contato</a></td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">Pizzaria Encontrada: <span id="quantidade-pizzaria"> ${pizzarias.size()} </span></td>
		</tr>
	</tfoot>
</table>