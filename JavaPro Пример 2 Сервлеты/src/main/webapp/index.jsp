<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Prog Academy</title>
  </head>
  <body>
    <% String login = (String)session.getAttribute("user_login"); %>
    <% Integer age=(Integer) session.getAttribute("user_age");%>
    <% if (age!=null) { %>
    <h1>The site is not available to users over the age of 18.</h1>
    <br>Click this link to <a href="/login?a=exit">logout</a>
   <%} else if (login == null || "".equals(login)) { %>
        <form action="/login" method="POST">
            Login: <input type="text" name="login"><br>
            Password: <input type="password" name="password"><br>
            Age: <input type="text" name="age"><br>
            <input type="submit" />
        </form>
    <%}else{ %>
        <h1>You are logged in as: <%= login %></h1>
        <br>Click this link to <a href="/login?a=exit">logout</a>
    <% } %>
  </body>
</html>