<%--
  Created by IntelliJ IDEA.
  User: elliottlarsen
  Date: 3/27/24
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reminder Update/Remove</title>
</head>
<body>
<form id="form1" action="/reminder/update" method="POST">
    <div>
        <input type="text" name="id" value="${dto.id}" readonly>
    </div>
    <div>
        <input type="text" name="reminder" value="${dto.reminder}" readonly>
    </div>
    <div>
        <input type="date" name="createDate" value="${dto.createDate}" readonly>
    </div>
    <div>
        <input type="date" name="dueDate" value="${dto.duDate}" readonly>
    </div>
    <div>
        <input type="checkbox" name="completed" ${dto.completed ? "checked" : ""}>
    </div>
</form>
<form id="form2" action="/reminder/remove" method="POST">
    <input type="hidden" name="id" value="${dto.id}" readonly>
    <div>
        <button type="submit">Remove</button>
    </div>
</form>
</body>
</html>
