<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论处理页面</title>
</head>
<body>
<%
    boolean flag = (boolean) request.getAttribute("flag_newRevert");
    int messageID = Integer.parseInt(request.getParameter("messageID"));
    if (flag) {
%>
<h2>评论成功</h2>
<h4>两秒后跳转到帖子回复界面,如果未跳转请点击<a href="RevertMessage?status=revertMessage&messageID=<%=messageID%>">这里</a></h4>
<%
} else {
%>
<h2>评论失败</h2>
<h4>两秒后跳转到帖子回复界面,如果未跳转请点击<a href="RevertMessage?status=revertMessage&messageID=<%=messageID%>">这里</a></h4>
<%
    }
%>
<%
    response.setHeader("refresh", "2;URL=RevertMessage?status=revertMessage&messageID="+messageID);
%>
</body>
</html>
