<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Resultados</title>
		<link rel="stylesheet" href="resources/css/materialize.min.css">
		<link rel="stylesheet" href="resources/css/style.css">
	</head>
	<body>
		<div class="container">
		
		<div class="row">
			<div class="s12 l8">
				<c:if test = "${all == 0}">
					<c:choose>
						<c:when test="${quantity==0}">
							<h3>No se encontraron coincidencias para "${term}" en ${criteria}</h3>
						</c:when>
						<c:when test="${quantity>1}">
							<h3>Se encontraron ${quantity} resultados para "${term}" en ${criteria}</h3>
						</c:when>
						<c:otherwise>
							<h3>Se encontró 1 resultado para "${term}" en ${criteria}</h3>
						</c:otherwise>
					</c:choose>
				</c:if>
				<c:if test = "${all == 1}">
					<c:choose>
						<c:when test="${quantity==0}">
							<h3>No se encontró ningún registro</h3>
						</c:when>
						<c:when test="${quantity>1}">
							<h3>Hay ${quantity} libros en existencia, de ${qauthors} autores diferentes</h3>
						</c:when>
						<c:otherwise>
							<h3>Se encontró 1 libro de ${qauthors} autores</h3>
						</c:otherwise>
					</c:choose>
				</c:if>
			</div>
			<div class="s12 l4">
				<button class="waves-effect waves-light btn blue" type="button" onclick="location.href='${pageContext.request.contextPath}/'">Regresar</button>
			</div>
		</div>
		
		<table class="highlight">
			<thead>
			<tr>
				<th data-field="isbn">ISBN</th>
				<th data-field="title">Título</th>
				<th data-field="author">Autor</th>
				<th data-field="stock">Existencias</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${books}" var="book">
			<tr>
				<th>${book.isbn}</th>
				<th>${book.titulo}</th>
				<th>${book.autor}</th>
				<th>${book.existencias}</th>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	</body>
</html>