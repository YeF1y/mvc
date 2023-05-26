<%--
  Created by IntelliJ IDEA.
  User: Dragon
  Date: 2023/5/10
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销页面</title>
</head>
<body>

<h2>您已成功注销!</h2>
<h4>两秒后跳转到登录界面,如果未跳转请点击<a href="login.jsp">这里</a></h4>
<%
    session.invalidate();
    response.setHeader("refresh", "2;URL=login.jsp");
%>

</body>
</html>

