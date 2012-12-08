<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css">
</head>
<body>
<h1><em>查看好友列表</em>_1.1</h1>
<p><img alt="${requestScope.userName}" src="${requestScope.userHead}"></p>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		var friends = "${requestScope.friends}";
		friends = eval(friends);	//解析为json字符串
		for(var i=0;i<friends.length;i++) {
			var friend =friends[i];
			$("body").append("<img src='"+friend.tinyurl+"' title='"+friend.name+"' class='head' width=50 hight=50>");
		}
		
		
	});
</script>
</body>
</html>