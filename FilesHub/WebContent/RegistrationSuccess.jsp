<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="bootstrap.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Success</title>
</head>
<body>

<h1 class="title">User <%= request.getParameter("uname")%> added successfully.</h1>
<h3>Please validate the address</h3>
<input type="button" name="login" value="< Go Back to login" onClick="location.href='http://localhost:8080/FilesHub/index.html'" />
</body>
</html>