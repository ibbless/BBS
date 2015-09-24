<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!</title>
</head>
<body>
	<s:actionmessage/>
	<br />
	<form action="<%=request.getContextPath()%>/User_LoginCheck" method="post">
		用户名:<input type="text" name="username" /><br /> 密码:<input
			type="password" name="password" /><br /> <input type="submit"
			value="登录" /> <input type="reset" value="清空" /><br />
	</form>


</body>
</html>