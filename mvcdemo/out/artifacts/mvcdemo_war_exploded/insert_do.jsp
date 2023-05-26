<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>新增帖子</title>
</head>
<body>
<%
	boolean flag = (boolean) request.getAttribute("flag_newMessage");
	if (flag) {
%>
<h2>新增成功</h2>
<h4>两秒后跳转到帖子管理界面,如果未跳转请点击<a href="Message?status=selectall">这里</a></h4>
<%
} else {
%>
<h2>新增失败</h2>
<h4>两秒后跳转到帖子管理界面,如果未跳转请点击<a href="Message?status=selectall">这里</a></h4>
<%
	}
%>
<%
	response.setHeader("refresh", "2;URL=Message?status=selectall");
%>
</body>
</html>
