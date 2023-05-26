<%@ page import="com.vo.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>帖子列表</title>
</head>
<body>
<h2>帖子列表</h2>
<h4>点击对应标题可进入评论区</h4>
<hr>
<a href="login_out.jsp">注销</a>
<%
	List<Message> allList = (List<Message>) request.getAttribute("all");
	Message message = null;
%>
<table border="2" style="margin-top: 20px;">
	<tr><th>帖子ID</th><th>标题</th><th>内容</th><th>作者</th><th>发帖时间</th><th>删除</th><th>编辑</th></tr>
	<%
		for (int i = 0; i < allList.size(); i++) {
			message = allList.get(i);
	%>
	<tr>
		<td><%=message.getMessageID()%></td>
		<td><a href="RevertMessage?status=revertMessage&messageID=<%=message.getMessageID()%>"><%=message.getTitle()%></a></td>
		<td><%=message.getContent()%></td>
		<td><%=message.getWriter()%></td>
		<td><%=message.getWriteDate()%></td>
		<td>
			<%
				String uname1 = request.getAttribute("uname").toString();
				if(Objects.equals(uname1, message.getWriter())){
					int MessageID = message.getMessageID();
			%>
			<a href="Message?status=delete&messageID=<%=MessageID%>">删除</a>
			<%
				}
			%>
		</td>
		<td>
			<%
				String uname2 = request.getAttribute("uname").toString();
				if(Objects.equals(uname2, message.getWriter())){
					int MessageID = message.getMessageID();
			%>
			<a href="Message?status=selectid&id=<%=MessageID%>">编辑</a>
			<%
				}
			%>
		</td>
	</tr>
	<%
		}
	%>
</table>

<a href="insert_note.jsp">新增一条留言</a>

</body>
</html>
