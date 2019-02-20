<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Wellcome to login</title>
</head>
<body>

<form action="/SessionTEST/loginact" method="post">
  name: <input type="text" id="username" name="username"><br>
  password: <input type="text" id="password" name="password"><br>
  <input type="submit" value="Submit">
</form>

<P> ${msg} </P>
<P> ${iname} </P>
<P> ${ipwd} </P>

</body>
</html>