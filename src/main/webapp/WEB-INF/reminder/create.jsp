<%--
  Created by IntelliJ IDEA.
  User: elliottlarsen
  Date: 3/24/24
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Reminder</title>
</head>
<body>
<form action="/reminder/create" method="POST">
    <div>
    <label>Reminder: </label>
    <textarea name="reminder" rows="4" cols="50">
    </textarea>
    </div>
    <div>
        <label>
            Due Date:
        </label>
        <input type="date" name="dueDate">
    </div>
    <div>
        <button type="reset">RESET</button>
        <button type="submit">CREATE</button>
    </div>
</form>
</body>
</html>
