<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  username is ${uname}. </P>
<input type="button" value="登出" onclick="location.href='/SessionTEST/logout'">
</body>
</html>
