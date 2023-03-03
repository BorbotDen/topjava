<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Den
  Date: 01.03.2023
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit meal</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Edit meal</h2>
<form action="meals" method="POST">
    <table>
        <tbody>
        <input type="hidden" name="id" value="<c:out value="${meal.id}"/>"/>
        <tr>
            <td>Date Time:</td>
            <td><input type="datetime-local" name="datetime" value="<c:out value="${meal.dateTime}"/>"/></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" value="<c:out value="${meal.description}"/>"/></td>
        </tr>
        <tr>
            <td>Calories:</td>
            <td><input type="number" min="1" name="calories" value="<c:out value="${meal.calories}"/>"/></td>
        </tr>

        </tbody>
    </table>
    <input type="submit" value="Save"/>
    <button onclick="window.history.back()" type="button">Cancel</button>
</form>
</body>
</html>
