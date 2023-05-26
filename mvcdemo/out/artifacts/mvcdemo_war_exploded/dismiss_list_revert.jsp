<%--
  Created by IntelliJ IDEA.
  User: Dragon
  Date: 2023/5/10
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论区</title>
</head>
<body>
    <h1>评论管理 </h1><hr /> 	<br />
<%
    request.setCharacterEncoding("utf-8") ;
    String keyword = (String) request.getParameter("keyword") ;
%>

    <h3><a href="dismiss_insert_revert.jsp">添加新评论</a></h3>

<table width="80%" border="1">
    <tr>
        <td>留言ID</td>
        <td>原贴作者ID</td>
        <td>评论者 </td>
        <td>内容 </td>
        <td>删除 </td>
    </tr>
    <c:forEach items="${all}" var="revert">
        <tr>
            <td>${revert.revertID}</td>
            <td>${revert.messageID}</td>
            <td>${revert.writer}</td>
            <td>${revert.content}</td>
            <td><a href="Revert?id=${revert.revertID}&status=delete">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
