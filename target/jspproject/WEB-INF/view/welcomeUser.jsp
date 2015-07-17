<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		WELCOME <b><%=request.getParameter("userName")%></b>!
	</h1>
	<br />
	<h1>
		<b><%=request.getParameter("userName")%></b> LOGGED IN AS : <b><%=request.getParameter("userRole")%></b>
	</h1>

	<h2>
		Roles associated with
		<%=request.getParameter("userName")%>
		are :
	</h2>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/USERPROFILE" user="root"
		password="root" />

	<sql:query dataSource="${snapshot}" var="result">
		SELECT * from USERPROFILE WHERE userid = <%=request.getParameter("userId")%>;
		</sql:query>
	<table>
		<tr>
			<td>User_Id</td>
			<td> Role</td>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.userid}" /></td>
				<td><c:out value="${row.role}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>