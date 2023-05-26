<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除评论处理页面</title>
</head>
<body>
<%
    boolean flag = (boolean) request.getAttribute("flag_deleteRevert");
    int messageID = Integer.parseInt(request.getParameter("messageID"));
    if (flag) {
%>
<h2>删除成功</h2>
<h4>两秒后跳转到评论区,如果未跳转请点击<a href="RevertMessage?status=revertMessage&messageID=<%=messageID%>">这里</a></h4>
<%
} else {
%>
<h2>删除失败</h2>
<h4>不许偷偷删别人的评论噢！！两秒后跳转到评论区,如果未跳转请点击<a href="RevertMessage?status=revertMessage&messageID=<%=messageID%>">这里</a></h4>
<%
    }
%>
<%
    response.setHeader("refresh", "2;URL=RevertMessage?status=revertMessage&messageID="+messageID);
%>
</body>
</html>
