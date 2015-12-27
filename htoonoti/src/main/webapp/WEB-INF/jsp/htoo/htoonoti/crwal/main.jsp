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
	(function() {
		var fnCallback = function(data) {
/* 			
			var _data = JSON.parse(data);
			var builder = [];
			for(key in _data){
				builder.push(key+':'+_data[key]+'<br/>');
			}
			var _html = builder.join('');
			$('#main').html(_html);
 */			
			debugger;
// 			$('#main').html(data);
			$('#main').append(data);
			
		};
		
		var params = {
				page: 0
		};
		
		var settings = {
			url: '/crwal/main.htoo',
// 			dataType: 'json',
			dataType: 'text',
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: params,
// 			method: 'POST',
			type: 'POST',
			async: true,
			success: fnCallback
		};
		
		var len = 10;
		for (var i = 0; i < len; i++) {
			debugger;
			$.ajax(settings);
			params.page++;
		}
		
	}());
});
</script>
</head>
<body>
<div class="wrap">
	<div class="contents">
		<div class="container">

			<div id="main">
				<span>
					메인
				</span>
			</div>
		
		</div>
	</div>
</div>
</body>
</html>