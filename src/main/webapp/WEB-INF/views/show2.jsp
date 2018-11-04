<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<c:set var="len2" value="${node2.list.size()}"/>
<c:choose>
<c:when test="${len2 < 1}">
<span class="gr"><c:out value="${node2.val}"></c:out></span>
</c:when>
<c:otherwise>
<span class="caret"><c:out value="${node2.val}"></c:out></span>
</c:otherwise>
</c:choose>
  <ul class="nested">
	<c:forEach var="node2" items="${node2.list}">
	<c:set var="node2" value="${node}" scope="request"/>
	<li><jsp:include page="show2.jsp"/></li>
	</c:forEach>
	</ul>
	
</body>
</html>