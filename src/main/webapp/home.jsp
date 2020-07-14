<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 7/14/20
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String firstname = "Chris";
String lastname = "E";%>

<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Hello, <%= firstname + " " +lastname%></h1>
<%@include file="aboutme.jsp"%>
</body>
</html>
