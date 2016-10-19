<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Guessing Game</title>
<link rel="stylesheet" type="text/css" href="Styles/Main_Style.css">
</head>
<body>
	<%!int tries = 10;%>
	<%
		ServletContext context = getServletContext();
		int test = (Integer) context.getAttribute("tries");
		String msg =(String) context.getAttribute("msg");
	%>
	<FORM action="GGHelperPage.jsp" method="POST">
		<center>
			Guesses Remaining:
			<%=test%>
			<br> Guess : <input type="text" name="guessedNumber"
				placeholder="--" required><br> <input type="Submit" class="button">
				<br><%=msg%>
		</center>
	</FORM>
</body>
</html>