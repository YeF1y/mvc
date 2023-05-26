<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>帖子修改</title>
</head>
<body>
	<h1>帖子修改</h1>
	<hr /> 	<br />
	<%
		request.setCharacterEncoding("utf-8") ;
		response.setHeader("refresh","2;URL=Message?status=selectall") ;
		boolean b = (Boolean) request.getAttribute("flag");
		if(b){
	%>
				帖子修改成功，两秒后跳转到帖子列表页！！！<br/>
				如果没有跳转，请按 <a href="Message?status=selectall">这里</a>！！！
	<%
		}else {
	%>
				你是不是在修改别人的帖子捏？<br/>
				帖子修改失败，两秒后跳转到帖子列表页 ！！！<br/>
				如果没有跳转，请按<a href="Message?status=selectall">这里</a>！！！
	<%
		}
	%>
</body>
</html>