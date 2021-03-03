<%@page import="com.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<%
	if (request.getParameter("itemCode") != null)
	 {
		 Item itemObj = new Item();
		 String stsMsg = itemObj.insertItem(request.getParameter("itemCode"),
			 request.getParameter("itemName"),
			 request.getParameter("itemPrice"),
			 request.getParameter("itemDesc"));
		 session.setAttribute("statusMsg", stsMsg);
	 }
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" 
crossorigin="anonymous">
</head>
<body>

	<h1>Items Management</h1>
	<form method="post" action="items.jsp">
	 Item code: <input name="itemCode" class="form-control" type="text"><br>
	 Item name: <input name="itemName" class="form-control" type="text"><br>
	 Item price: <input name="itemPrice" class="form-control" type="text"><br>
	 Item description: <input name="itemDesc" class="form-control" type="text"><br>
	 <input name="btnSubmit" type="submit" value="Save">
	</form>
	
	<%
 		out.print(session.getAttribute("statusMsg"));
	%>
	
	
	<br>
	<%
	 Item itemObj = new Item();
	 out.print(itemObj.readItems());
	%>
	
</body>
</html>