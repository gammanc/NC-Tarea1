<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="resources/css/materialize.min.css">
		<link rel="stylesheet" href="resources/css/style.css">
		<title>Biblioteca</title>
	</head>
	<body>
		<div class="container">
			<div class="col s12 m6 section">
				<div class="card large">
				<div class="container">
				<br><br>
				<h1 class="header center blue-text">Biblioteca</h1>
				<div class="row center">
				  <h5 class="header col s12 light">Busca por título, autor, ISBN o género</h5>
				</div>
				
				<div class="row">
					<form action="${pageContext.request.contextPath}/search" method="post">
						<div class="col s12">
							<div class="row">
								<div class="input-field col s12 l8">
									<label for="term_input">Buscar: </label>
									<input type="text" id="term_input" name="term" autocomplete="off" class="validate" required>
									<span class="helper-text" data-error="Ingresa un término para buscar"></span>
								</div>
								<div class="input-field col s12 l4">
									<form:select name="criteria" path="criteria">
										<form:options items="${criteria}"/>
									</form:select>
									<label>Por:</label>
								</div>	
							</div>
							<div class="row center-align">
									<button type="submit" class="btn-large waves-effect waves-light blue">
										Buscar
									</button>
									<button type="button" class="btn-large waves-effect waves-blue white"
										onclick="location.href='${pageContext.request.contextPath}/showAll'">
										Ver todos
									</button>
							</div>
						 </div>
					</form>
				</div>
				</div>
			</div>
			</div>
			<br><br>
		</div>
			
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="resources/js/materialize.min.js"></script>
		<script type="text/javascript">
		 $(document).ready(function(){
			    $('select').formSelect();
			  });
		</script>
	</body>
</html>