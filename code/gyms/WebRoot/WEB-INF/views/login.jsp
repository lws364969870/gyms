<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.login {
			position: absolute; 
			height: 100%;
			width: 100%;
			left: 0;
			top: 0;
			background-image: url("${pageContext.request.contextPath}/img/system/welcome.jpg");
			background-color: #ccc;
			background-size: 100% 100%;
		}
	</style>
  </head>
  
  
<body>
	<div class="login">
    <form action="${pageContext.request.contextPath}/LoginController/login" method="post">        
                    <input type="text" name="username" >
                    <input type="password" name="password" >
                    <button type="submit" id="login-button">Login</button>
    </form> 
    ${msg} 
	</div>
</body>
</html>
