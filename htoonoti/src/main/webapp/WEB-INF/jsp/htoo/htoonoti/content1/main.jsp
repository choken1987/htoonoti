<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="site" value="htoonoti || "></c:set>
<c:set var="title" value="${site}content1"></c:set>
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
});
</script>
</head>
<body>
<div class="wrap">
	<div class="contents">
		<div class="container">

			<div>
				<span>
					content1 main
				</span>
			</div>
		
		</div>
	</div>
</div>
</body>
</html>