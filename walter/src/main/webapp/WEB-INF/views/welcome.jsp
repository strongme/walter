<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>

<style type="text/css">
	#head{
		position: absolute;
		top: 10px;
		left: 33%;
		color: white;
	}
	body {
		/* background-color: rgb(185,110,0); */
		background-image: url(images/Wallpaper.jpg);
		
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
<h1 id="head">WELCOME TO Strongme APP</h1>
</body>
</html>