<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path=request.getContextPath();
%>
</head>
<body>
	<form action="<%=path%>/message" method="post">
		<table>
		<tr>
			<td>姓名:</td><td><input name="name"/></td>
		</tr>
		<tr>
			<td>留言:</td><td><input name="message"/></td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">提交</button></td>
		</tr>
		</table>
	</form>
</body>
</html>