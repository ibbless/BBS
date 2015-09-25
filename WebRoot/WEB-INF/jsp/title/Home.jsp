<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>home</title>
</head>
<body>
	欢迎你，${sessionScope.username }
	<a href="<%=request.getContextPath()%>/user/User_Logout.action">注销</a>
	<br />
		<s:iterator value="#request.list" id="list" status="rowstatus">
			<span><s:property value="#list.content" /></span>
			<span><s:property value="#list.postTime" /></span>
		</s:iterator>

</body>
</html>