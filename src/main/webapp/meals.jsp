<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<hr>
<h2>Meals</h2>
<h3><a href="newmeal.jsp">Add meal</a></h3>
<table border="1">
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th width="50"></th>
        <th width="50"></th>
    </tr>
    <c:forEach var="mealsTo" items="${listMealsTo}">
        <c:set var="color" value="${mealsTo.excess ? 'crimson' : 'green'}"/>
        <tr style="color: ${color} ">
            <td>${mealsTo.date} ${mealsTo.time}</td>
            <td>${mealsTo.description}</td>
            <td>${mealsTo.calories}</td>
            <td><a href="meals?action=edit&id=<c:out value="${mealsTo.id}"/>">Update</a></td>
            <td><a href="meals?action=delete&id=<c:out value="${mealsTo.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>