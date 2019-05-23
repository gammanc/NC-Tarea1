<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${message}</title>
</head>
<body>
	<h1>${message}</h1>
	<form:form action="${pageContext.request.contextPath}/formData" method="POST" modelAttribute="student">
		<form:input type="hidden" name="id" path="cStudent"/>
             <table>
                <tr>
                    <td><label>Titulo : </label></td>
                    <td><form:input type="text" name="title" path="titulo"/></td>
                </tr>
                <tr>
                    <td><label>Autor: </label></td>
                    <td><form:input type="text" name="author" path="autor"/></td>
                </tr>
                <tr>
                    <td><label>ISBN: </label></td>
                    <td><form:input type="text" name="isbn" path="isbn"/></td>
                </tr>
                <tr>
                    <td><label>Existencias: </label></td>
                    <td><form:input type="number" name="stock" path="existencias"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Guardar"/></td>
                </tr>
            </table>
        </form:form>
</body>
</html>