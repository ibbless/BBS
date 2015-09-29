<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${topic.title}</title>
</head>
<body>
	标题：
	<s:property value="#topic.title" />
	<br /> 内容：
	<s:property value="#topic.content" />
	<br /> 作者：
	<s:property value="#topic.author.username" />
	<br /> 发表时间：
	<s:property value="#topic.postTime" />
	<br /> 回复列表：
	<br />
	<s:iterator value="recordList" status="st">
		<s:property value="#st.index" />楼：<br />
回复内容：${content }<br />
回帖人：${author.username}<br />
回复时间：${postTime }<br />
		<s:a action="Reply_Delete?topicId=%{topic.id}&replyId=%{id}">删除</s:a>
	</s:iterator>
	<br> ${currentPage }页 / ${pageCount } 页
	<br> 总共${recordCount }条
	<br> 添加回复：
	<form action="Reply_Save?topicId=${topic.id}" method="post">
	内容：<input name="content" type="text"/><br>
	<input type="submit" value ="发送"><br>
	</form>

</body>
</html>