<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<script src="${path}/include/jquery-3.6.0.min.js"></script>
<style type="text/css">
nav {
	margin: 0;
	padding: 0;
	
}
</style>
<title>홈</title>
</head>
<body>
<%@ include file="include/nav.jsp" %>
</body>
</html>
