<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<jsp:include page="../menu-cliente.jsp"></jsp:include>
		
		<section>
			<div id="consulta-pizzaria">
				<label for="pizza_pesquisa">Que pizza você quer comer hoje?</label>
				<select class="form-control">
					<c:forEach items="${nomesPizzas}" var="nomePizza">
						<option value="${nomePizza}">${nomePizza}</option>
					</c:forEach>
				</select>
			</div>
			
			<div id="secao-pizzaria"></div>
		</section>
	</body>
</html>