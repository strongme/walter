<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>

<style type="text/css">
	#head{
		position: relative;
		top: 200px;
		left: 25%;
	}
	body {
		background-color: rgb(44,33,12);
}
</style>
</head>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/renren.js"></script>
<script type="text/javascript">
	var uiOpts = {
		url : "http://graph.renren.com/oauth/authorize",
		display : "iframe",
		params : {
			"response_type" : "token",
			"client_id" : "${requestScope.appId}",
			"scope" : "read_user_photo read_user_feed read_user_blog read_user_album"
		},
		onSuccess : function(r) {
			top.location = "http://apps.renren.com/strongme/home";
		},
		onFailure : function(r) {
		}
	};
	Renren.ui(uiOpts);
</script>
<h1 id="head">WELCOME TO THE SPRING WORLD</h1>
</body>
</html>