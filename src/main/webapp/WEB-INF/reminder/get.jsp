<%--
  Created by IntelliJ IDEA.
  User: elliottlarsen
  Date: 3/25/24
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reminder Get</title>
</head>
<body>
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
    <input type="date" name="dueDate" value="${dto.dueDate}" readonly>
</div>
<div>
    <input type="checkbox" name="completed" ${dto.completed? "checked": ""} readonly>
</div>
<div>
    <a href="/reminder/update?id=${dto.id}">Update/Remove</a>
    <a href="/reminder/list">List</a>
</div>
</body>
</html>
