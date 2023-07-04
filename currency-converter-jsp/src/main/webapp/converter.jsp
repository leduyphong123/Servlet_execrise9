<%--
  Created by IntelliJ IDEA.
  User: leduy
  Date: 7/4/2023
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<%
    float rate = Float.parseFloat(request.getParameter("rate"));
    float usd = Float.parseFloat(request.getParameter("usd"));
    float result = rate * usd;
%>
<h1>Rate: <%=rate%></h1>
<h1>Usd: <%=usd%></h1>
<h1>Result: <%=result%></h1>
</body>
</html>
