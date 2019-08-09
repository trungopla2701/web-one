<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Khangdinh
  Date: 08/08/2019
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Title</title>
</head>
<body>
<c:forEach items="${tables}" var="item">
		<h1>${item.userName}</h1>
		<h1>${item.password}</h1>
	</c:forEach>
</body>
</html>
