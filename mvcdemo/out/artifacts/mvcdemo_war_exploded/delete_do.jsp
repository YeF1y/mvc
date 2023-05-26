<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>删除帖子</title>
</head>
<body>
<%
	boolean flag = (boolean) request.getAttribute("flag_delete");
	if (flag) {
%>
<h2>删除成功</h2>
<h4>两秒后跳转到帖子管理界面,如果未跳转请点击<a href="Message?status=selectall">这里</a></h4>
<%
} else {
%>
<h2>删除失败</h2>
<h4>两秒后跳转到帖子管理界面,如果未跳转请点击<a href="Message?status=selectall">这里</a></h4>
<%
	}
%>
<%
	response.setHeader("refresh", "2;URL=Message?status=selectall");
%>
</body>
</html>
