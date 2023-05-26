<jsp:useBean id="message" scope="request" type="com.vo.Message"/>
<%@ page import="com.vo.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改帖子</title>
</head>
<body>

<h1>修改帖子</h1>	<hr /> <br />

<form action="Message" method="post">
    <table>
        <tr><td colspan="2">编辑帖子 </td></tr>
        <tr><td>标题：</td>
            <td><input type="text" name="title" value="${message.title}"></td>
        </tr>
        <tr><td>作者：</td>
            <td>${sessionScope.uname}
                <input type="hidden" name="writer" value="${uname}" /></td>
        </tr>
        <tr><td>内容：</td>
            <td><textarea name="content" cols="30" rows="6">${message.content}</textarea></td>
        </tr>
        <tr><td colspan="2">
            <input type="hidden" name="id" value=${message.messageID}>
            <input type="hidden" name="status" value="update">
            <input type="submit" value="更新">
            <input type="reset" value="重置">
        </td>
        </tr>
    </table>
</form>

<h3><a href="Message?status=selectall">回到帖子列表页</a></h3>
</body>
</html>