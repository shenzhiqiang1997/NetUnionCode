<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path=request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function deleteMessage(id){
		var deleteForm=$("#deleteForm");
		deleteForm.attr("action",deleteForm.attr("action")+id);
		deleteForm.submit();
		
	}
</script>
</head>
<body>
<form action="<%=path%>/message/messages" method="post">
	<table>
	<tr>
		<th>姓名</th>
		<th>留言</th>
		<th>时间</th>
		<th colspan="3">操作</th>
		<th><a href="<%=path%>/views/add.jsp">添加</a></th>
	</tr>
	<tr>
		<th><input type="text" name="name"/></th>
		<th><input type="text" name="message"/></th>
		<th><input type="text" name="time" disabled="disabled"/></th>
		<th colspan="3"><button type="submit">搜索</button></th>
	</tr>
	<c:forEach items="${messages}" var="message">
		<tr>
			<td>${message.name }</td>
			<td>${message.message }</td>
			<td><fmt:formatDate value="${message.time }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td><a href="<%=path%>/message/${message.id}">查看</a></td>
			<td><a onclick="deleteMessage(${message.id})" href="#">删除</a></td>
		</tr>
	</c:forEach>
	</table>
</form>
<form action="<%=path %>/message/delete/" method="post" id="deleteForm">
	<input type="hidden" name="_method" value="delete"/>
</form>
<c:if test="${message!=null }">
	<script type="text/javascript">
		alert("${messsage}");
	</script>
</c:if>
</body>
</html>