<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>MVC+DAO留言管理程序--登陆</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	if (session.getAttribute("uname") != null) {
%>
<h2 >欢迎<b><%=session.getAttribute("uname")%></b></h2>
<h2 >光临阿巴啊吧</h2>
<h2><a href="Message?status=selectall">点击进入贴吧</a></h2>
<%
	Object count = application.getAttribute("count");
	int co;
	if(count == null){
		application.setAttribute("count",1);
		count = application.getAttribute("count");
	}
	co = Integer.parseInt(count.toString());
%>
<h5>您是第<%=co++%>个访客!</h5>
<%
	application.setAttribute("count", co);
%>
<%
}else{
	session.setAttribute("err", "请重新输入用户名和密码");
	response.setHeader("refresh","2;URL=login.jsp");
%>
<h5>您尚未登录,页面2秒后跳转到登录页面</h5>
<%
	}
%>
</body>
</html>