<%--
  Created by IntelliJ IDEA.
  User: dela
  Date: 6/19/17
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="currentime" class="java.util.Date" scope="application" />
<html>
    <head>
        <title>当前时间</title>
    </head>
    <body>
        <%= currentime.toString()%>
    </body>
</html>