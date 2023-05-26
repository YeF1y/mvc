<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>新增帖子</title>
</head>
<body>
<h2>新增帖子</h2>
<form action="Message?status=newMessage" method="post">
	<h5>添加新帖子</h5>
	<h5>标题:  <input type="text" name="title" value="" style="width: 200px;"> </h5>
	<h5>发帖人:<%=session.getAttribute("uname")%></h5>
	<h5>内容:  <textarea name="context" style="width: 200px; height: 150px; vertical-align: top; text-align: left;"></textarea></h5>
	<button type="submit">添加</button> <button type="reset">重置</button>
</form>
<a href="Message?status=selectall">回到帖子列表页</a>
</body>
</html>
