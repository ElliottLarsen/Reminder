<%--
  Created by IntelliJ IDEA.
  User: elliottlarsen
  Date: 3/23/24
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Reminder List</title>
</head>
<body>
<h1>Reminder List</h1>
<ul>
    <c:forEach items="${dtoList}" var="dto">
        <li>${dto}</li>
    </c:forEach>
</ul>
</body>
</html>
