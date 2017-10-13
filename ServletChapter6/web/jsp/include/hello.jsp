<%--
  Created by IntelliJ IDEA.
  User: dela
  Date: 6/9/17
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<html>
    <head>
        <title>hello servlet</title>
    </head>
        <body>
        <%
            String name = request.getParameter("name");
        %>
        <h1>hello! <%= name%></h1>
    </body>
</html>