<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Final Project</title>
<link rel="stylesheet" type="text/css" href="Styles/Main_Style.css">
</head>
<body>
	<%
		ServletContext context = getServletContext();
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		context.getAttribute("conn");
		context.setAttribute("username", userName);
		boolean okay = Servlets.checkLogin.checkValid((java.sql.Connection) context.getAttribute("conn"), userName,
				passWord);
		if (okay == true) {
	%>
	test TRUE
	<%
		context.setAttribute("guessNum", 1 + ((int)(Math.random() * 100)));
		context.setAttribute("tries", 10);
		response.sendRedirect("GGameEngine.jsp");
		} else {
	%>
	Your login is not correct:
	<a href="GGForm.html">Click here to try again or register</a>
	<%
		}
	%>
</body>
</html>