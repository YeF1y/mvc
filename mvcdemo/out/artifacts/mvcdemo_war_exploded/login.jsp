<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
  </head>
  
  <body>
  <form action="Login" method="post" style="margin-left: 500px;margin-top: 180px;">
	  <b>用户ID:</b> <br/>
	  <input  type="text" name="id" placeholder="请输入学号"/>
	  <br/>
	  <b>用户密码:</b> <br/>
	  <input  type="password" name="password" placeholder="请输入密码"/>
	  <br/>
	  <button type="submit" style="margin-top: 10px">登录</button>
  </form>
  </body>
</html>
