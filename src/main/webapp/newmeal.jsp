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
    <title>Create new meal</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Creat new meal</h2>
<form action="meals" method="POST">
    <table>
        <tbody>
        <tr>
            <td>Date Time:</td>
            <td><input type="datetime-local" name="datetime"></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description"/></td>
        </tr>
        <tr>
            <td>Calories:</td>
            <td><input type="number" min="1" name="calories"/></td>
        </tr>

        </tbody>
    </table>
    <input type="submit" value="Create"/>
    <button onclick="window.history.back()" type="button">Cancel</button>
</form>
</body>
</html>
