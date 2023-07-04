<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: leduy
  Date: 7/4/2023
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>

<%! Map<String, String> dictionary = new HashMap<>();%>
<%
    dictionary.put("hello", "Xin chào");
    dictionary.put("how", "Thế nào");
    dictionary.put("book", "Quyển vở");
    dictionary.put("computer", "Máy tính");
    String dic = request.getParameter("txtSearch");
    String result = dictionary.get(dic);
    PrintWriter output = response.getWriter();
    if(result !=null){
        output.println(result);
    }else {
        output.println("not dictionary");
    }
%>

</body>
</html>
