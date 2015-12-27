<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="index"></c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>${title}</title>
<%@ include file="/WEB-INF/jsp/common/include/header.jsp" %>
<style type="text/css">
</style>
<script type="text/javascript">
$(document.body).ready(function(){
	$('#content1').on('click', function(){
		window.location.href = '/content1.htoo';
	});
});
</script>
</head>
<body>
<div class="wrap">
	<div class="contents">
		<div class="container">

			<div>
				<span>
					<a id="content1">content1</a>
				</span>
			</div>
		
		</div>
	</div>
</div>
</body>
</html>