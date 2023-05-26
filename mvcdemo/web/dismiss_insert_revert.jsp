<%@ page import="com.vo.dismiss_Note" %><%--
  Created by IntelliJ IDEA.
  User: Dragon
  Date: 2023/5/10
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>插入新的评论</title>
</head>
<body>
<%
    dismiss_Note note = new dismiss_Note();
%>
<h1>评论管理</h1>
<hr />	<br />
<form action="Revert" method="post">
    <table>
        <tr><td colspan="2">添加新评论</td></tr>
        <tr>
            <td>评论者id：</td>
            <td><%=session.getAttribute("uid")%>
                <input type="hidden" name="revertID" value="<%=session.getAttribute("id")%>"/></td>
        </tr>
        <tr>
            <td>原贴id：</td>
            <td><%=note.getId()%>
                <input type="hidden" name="messageID" value="<%=note.getId()%>"/></td>
        </tr>
        <tr>
            <td>评论者：</td>
            <td><%=session.getAttribute("uname")%>
                <input type="hidden" name="writer" value="<%=session.getAttribute("uname")%>"/></td>
        </tr>
        <tr>
            <td>内容：</td>
            <td><textarea name="content" cols="30" rows="6"></textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="hidden" name="status" value="insert">
                <input type="submit" value="添加">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
    <h3><a href="list_note.jsp">回到留言列表页</a></h3>
</body>
</html>
