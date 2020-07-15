<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 7/15/20
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (request.getMethod().equalsIgnoreCase("post")) {
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	if (username.equals("admin") & password.equals("password")) {
    		response.sendRedirect("/profile.jsp");
        } else {
    		response.sendRedirect("/login.jsp");
        }
    }
%>

<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Please login</h1>
    <form action="/login.jsp" method="post">
        <label for="username">
            <input type="text" id="username" name="username" placeholder="Username">
        </label>
        <label for="password">
            <input type="password" id="password" name="password" placeholder="Password">
        </label>
        <button type="submit">Log in</button>
    </form>
</body>
</html>
