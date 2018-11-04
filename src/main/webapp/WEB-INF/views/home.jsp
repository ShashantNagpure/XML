<%@page import="org.w3c.dom.Node"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
ul, .myUL {
  list-style-type: none;
}

/* Remove margins and padding from the parent ul */
.myUL{
  margin: 0;
  padding: 0;
}

/* Style the caret/arrow */
.caret {
  cursor: pointer; 
  user-select: none; /* Prevent text selection */
}

/* Create the caret/arrow with a unicode, and style it */
.caret::before {
  content: "\25B6";
  color: black;
  display: inline-block;
  margin-right: 6px;
}

/* Rotate the caret/arrow icon when clicked on (using JavaScript) */
.caret-down::before {
  transform: rotate(90deg); 
}

/* Hide the nested list */
.nested {
  display: none;
}

/* Show the nested list when the user clicks on the caret/arrow (with JavaScript) */
.active {
  display: block;
}
.gr
{
	color:LightGray
}
* {
    box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
    float: left;
    width: 50%;
    padding: 10px;
    height: 300px; /* Should be removed. Only for demonstration */
}

</style>

</head>
<body>
<script src="demojs.js"></script>
   <script src="http://code.jquery.com/jquery-1.5.js"></script>
   <script>
    $(document).ready(function() {
   $("#a").click(function() {
   $.post("htmlparser", { htm : $( "#cool" ).html()});
   });
 });
    </script>
<div class="column">
<ul class="myUL">
<li>
<c:set var="len" value="${node.list.size()}"/>
<c:choose>
<c:when test="${len < 1}">
<span class="gr"><c:out value="${node.val}"></c:out></span>
</c:when>
<c:otherwise>
<span class="caret"><c:out value="${node.val}"></c:out></span>
</c:otherwise>
</c:choose>
  <ul class="nested">
	<c:forEach var="node" items="${node.list}">
	<c:set var="node" value="${node}" scope="request"/>
	<li><jsp:include page="show.jsp"/></li>
	</c:forEach>
	</ul>
	</li>
	</ul>
	</div>
	<div class= "column">
<ul class="myUL" id="cool">
<li>
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
	<c:set var="node" value="${node2}" scope="request"/>
	<li><jsp:include page="show.jsp"/></li>
	</c:forEach>
	</ul>
	</li>
	</ul>
	</div>
		<button id="a">click here</button>
<script>
var toggler = document.getElementsByClassName("caret");
var i;

for (i = 0; i < toggler.length; i++) {
  toggler[i].addEventListener("click", function() {
    this.parentElement.querySelector(".nested").classList.toggle("active");
    this.classList.toggle("caret-down");
  });
}

</script>
  </body>
</html>