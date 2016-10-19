<%@page import="Servlets.userScoreServlet"%>
<%@page import="coreServlets.GGHelper"%>
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
		String guessNumber = request.getParameter("guessedNumber");
	%>
	<%
		ServletContext context = getServletContext();
	%>
	<%
	boolean guessedCorrectly = GGHelper.checkGuess(context.getAttribute("guessNum"), guessNumber);
	%>
	<%
		int holder = (Integer) context.getAttribute("tries");
		if(guessedCorrectly==false){
			context.setAttribute("tries", holder - 1);
			holder = (Integer) context.getAttribute("tries");
			if(holder==0){
				%>
				Game over!
				<br><a href="GGameEngine.jsp">Play again</a>
				<%			
				context.setAttribute("msg", "");
				context.setAttribute("tries", 10);
				context.setAttribute("guessNum", 1 + ((int) (Math.random() * 100)));
			}else{
			context.setAttribute("msg", "Your guess is wrong! Please try again");
			response.sendRedirect("GGameEngine.jsp");
					}
		}else{
			%>You are correct!
			<br><a href="GGameEngine.jsp">Play again</a><% 			
		userScoreServlet.addPoint((java.sql.Connection) context.getAttribute("conn"),(String) context.getAttribute("username"));
		context.setAttribute("msg", "");
		context.setAttribute("tries", 10);
		context.setAttribute("guessNum", 1 + ((int) (Math.random() * 100)));
		}
		%>
</body>
</html>