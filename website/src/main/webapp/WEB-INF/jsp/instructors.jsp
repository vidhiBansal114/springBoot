<%@page import="java.util.HashMap" %>
<%@page import="java.util.ArrayList" %>

<html>
<h1>List of instructors</h1>
<%
	ArrayList<HashMap<String,Object>> listOfInstructors=(ArrayList<HashMap<String,Object>>)request.getAttribute("instructors");
	for(HashMap<String,Object>instructor:listOfInstructors){
%>
name:<%=instructor.get("name") %>
<a href="/profile/<%=instructor.get("id") %>" >profile</a>
<%} %> 
</html>