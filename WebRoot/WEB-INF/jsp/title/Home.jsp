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
		<s:iterator value="list" id="list" status="rowstatus">
			标题：<s:a action="Topic_Show?TopicId=%{id }"><span>${title }</span></s:a><br/>
			内容：<span>${content }</span><br/>
			date:<span>${postTime}</span><br/>
		</s:iterator>

</body>
</html>