<%--
  Created by IntelliJ IDEA.
  User: svetlana
  Date: 23.02.2023
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prog Academy</title>
</head>
<body>
<% String name = (String) session.getAttribute("user_name"); %>
<% String lastName = (String) session.getAttribute("user_last_name"); %>
<% Integer age = (Integer) session.getAttribute("user_age"); %>


<%if (name == null || "".equals(name) && lastName == null || "".equals(lastName) && age == null || age == 0) { %>
<form action="/registration" method="POST">
    Name: <input type="text" name="name"><br>
    Last Name: <input type="text" name="lastName"><br>
    Age: <input type="text" name="age"><br>
    <input type="submit"/>
</form>
<%} else if (!"".equals(name) && !"".equals(lastName) && age != null) { %>
<form action="/question" method="POST">
    Do you like Java?
    <br/> <input type="radio" name="question1" value="yes"/> Yes
    <br/> <input type="radio" name="question1" value="no"/> No
    <br/> Do you like .NET?
    <br/> <input type="radio" name="question2" value="yes"/> Yes
    <br/> <input type="radio" name="question2" value="no"/> No
    <br/> <input type="submit"/>
</form>
<%}%>
</body>
</html>
