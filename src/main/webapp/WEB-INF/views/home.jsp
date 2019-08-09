<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Son Dep Trai
  Date: 7/20/2019
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h1>--%>
<%--	Đây là trang home--%>
<%--</h1>--%>
<%--//trả 1 cái--%>
<%--	${model};--%>
<%--// trả về 1ist--%>
<%--<c:forEach items="${model}" var="item">--
<%--	<h1>${item.id}</h1>--%>
<%--	<h1>${item.name}</h1>--%>
<%--	<h1>${item.description}</h1>--%>
<%--&lt;%&ndash;	<h1>${item.id}</h1>&ndash;%&gt;--%>
<%--&lt;%&ndash;	<h1></h1>&ndash;%&gt;--%>
<%--	<a href="/home/1"></a>--%>
<%--</c:forEach>--%>

<%--đây là vòng lặp for--%>
<%--var là tên biến / items là danh sách , tên list--%>

<%--<c:forEach items="${models}" var="item">--%>
<%--	<h1>${item.id}</h1>--%>
<%--</c:forEach>--%>

<form action="/admin/home" method="GET">
	<input placeholder="username" name="userName">
	<input placeholder="password" name="password">
	<button type="submit">click</button>
</form>

<h1>${models}</h1>

<h2>${password}</h2>
<c:forEach items="${table}" var="item">
		<h1>${item.userName}</h1>
		<h1>${item.password}</h1>
	</c:forEach>
</body>
</html>
