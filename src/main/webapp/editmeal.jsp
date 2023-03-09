<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${meal.id != null}">
        <title>Edit meal</title>
    </c:if>
    <c:if test="${meal.id == null}">
        <title>Create meal</title>
    </c:if>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<c:if test="${meal.id != null}">
    <h2>Edit meal</h2>
</c:if>
<c:if test="${meal.id == null}">
    <h2>Create meal</h2>
</c:if>

<form action="meals" method="POST">
    <table>
        <tbody>
        <c:if test="${meal.id != null}">
            <input type="hidden" name="id" value="${meal.id}"/>
        </c:if>
        <tr>
            <td>Date Time:</td>
            <td><input type="datetime-local" name="datetime" value="${meal.dateTime}"/></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" value="${meal.description}"/></td>
        </tr>
        <tr>
            <td>Calories:</td>
            <td><input type="number" min="1" name="calories" value="${meal.calories}"/></td>
        </tr>

        </tbody>
    </table>
    <input type="submit" value="Save"/>
    <button onclick="window.history.back()" type="button">Cancel</button>
</form>
</body>
</html>
