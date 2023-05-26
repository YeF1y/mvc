<%@ page import="com.vo.Message" %>
<%@ page import="com.vo.Revert" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: Dragon
  Date: 2023/5/10
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖子详情</title>
</head>
<body>
<a href="Message?status=selectall">回到帖子列表页</a>
<h2>帖子详情</h2>
<%
    Message messageDetail = (Message) request.getAttribute("messageDetail");
%>
<table border="2" style="margin-top: 20px;">
    <tr>
        <td>帖子ID:</td>
        <td><%=messageDetail.getMessageID()%></td>
    </tr>
    <tr>
        <td>标题:</td>
        <td><%=messageDetail.getTitle()%></td>
    </tr>
    <tr>
        <td>楼主:</td>
        <td><%=messageDetail.getWriter()%></td>
    </tr>
    <tr>
        <td>内容:</td>
        <td><%=messageDetail.getContent()%></td>
    </tr>
    <tr>
        <td>发帖时间:</td>
        <td><%=messageDetail.getWriteDate()%></td>
    </tr>
</table>

<hr>

<h2>评论详情</h2>
<%
    List<Revert> allList = (List<Revert>) request.getAttribute("listRevert");
    Revert revert = null;
%>
<table border="2" style="margin-top: 20px;">
    <tr><th>楼层</th><th>评论ID</th><th>内容</th><th>评论者</th><th>评论时间</th><th>删除</th></tr>
    <%
        for (int i = 0; i < allList.size(); i++) {
            revert = allList.get(i);
    %>
    <tr>
        <td><%=(i+1)%></td>
        <td><%=revert.getRevertID()%></td>
        <td><%=revert.getContent()%></td>
        <td><%=revert.getWriter()%></td>
        <td><%=revert.getWriterDate()%></td>
        <td>
            <%
                String uname = request.getAttribute("uname").toString();
                if(Objects.equals(uname, revert.getWriter())){
                    int revertID = revert.getRevertID();
                    int messageID = revert.getMessageID();
            %>
            <a href="RevertMessage?status=delete&messageID=<%=messageID%>&revertID=<%=revertID%>">删除</a>
            <%
                }
            %>
        </td>
    </tr>
    <%
        }
    %>
</table>

<hr>
<%
    String uname = session.getAttribute("uname").toString();
%>
<h2>评论</h2>
<form action="RevertMessage?status=newRevert" method="post">
    <input type="hidden" name="messageID" value="<%=messageDetail.getMessageID()%>">
    <h5>评论内容:  <textarea name="content" style="width: 200px; height: 150px; vertical-align: top; text-align: left;"></textarea></h5>
    <input type="hidden" name="writer" value="<%=uname%>">
    <button type="submit">回帖</button> <button type="reset">重置</button>
</form>

</body>
</html>
