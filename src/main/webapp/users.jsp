<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <title>Users</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Users</h2>
<br><br>
<table  border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Roles</th>
        <th>Activation</th>
        <th>Registration date</th>
    </tr>
    </thead>
    <c:forEach items="${requestScope.users}" var="user">
        <jsp:useBean id="user" type="ru.javawebinar.topjava.model.User"/>
        <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.roles}</td>
            <td>${user.enabled}</td>
            <td>${user.registered}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>