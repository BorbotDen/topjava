<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<hr>
<h2>Meals</h2>
<h3><a href="users">Add meal</a></h3>
<table border="1">
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th width="50"></th>
        <th width="50"></th>
    </tr>

    <c:forEach var="mealsTo" items="${listMealsTo}">
        <c:choose>
            <c:when test="${mealsTo.getExcess()}">
                <tr style="color: crimson">
            </c:when>
            <c:otherwise>
                <tr style="color: green">
            </c:otherwise>
        </c:choose>

        <td>${mealsTo.getDate()} ${mealsTo.getTime()}</td>
        <td>${mealsTo.getDescription()}</td>
        <td>${mealsTo.getCalories()}</td>
        <td><a href="index.html">Update</a></td>
        <td><a href="index.html">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>