<%--
  Created by IntelliJ IDEA.
  User: dela
  Date: 5/22/17
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>

<%--include指示类型就是将多个jsp合并成一个jsp进行编译, 但是include的应该是jspf文件
    jspf可以看作是jsp文件include进来的--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@include file="header.jspf"%>
    <h1>include 示范主体</h1>
<%@include file="foot.jspf" %>