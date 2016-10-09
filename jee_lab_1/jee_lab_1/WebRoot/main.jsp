<%@ page language="java" pageEncoding="gb2312" import="org.model.Login"%>
<html>
<head>
	<title>欢迎使用</title>
</head>
<body>
	<%
		Login login=(Login)session.getAttribute("login");	//从会话中取出 Login 对象
		String lgn=login.getName();							//通过 JavaBean 对象获取用户名
	%>
	<%=lgn%>，您好！欢迎使用图书管理系统。
</body>
</html>
