<%@page import="com.PAF.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<%
	//Insert item------------------------------
	if (request.getParameter("itemCode") != null)
	 {
		 Item itemObj = new Item();
		 String stsMsg = itemObj.insertItem(
			 request.getParameter("itemCode"),
			 request.getParameter("itemName"),
			 request.getParameter("itemPrice"),
			 request.getParameter("itemDesc"));
		 session.setAttribute("statusMsg", stsMsg);
	 }


	//Delete item----------------------------------
	if (request.getParameter("itemID") != null) 
	{ 
		Item itemObj = new Item(); 
		String stsMsg = itemObj.deleteItem(request.getParameter("itemID")); 
		session.setAttribute("statusMsg", stsMsg); 
	} 
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<link rel="stylesheet" href="Views/main-styles.css">
</head>
<body>

	<div class="container">
	<h1>Items Management</h1>
	<form method="post" action="items.jsp">
	 Item code: <input name="itemCode" class="form-control" type="text"><br>
	 Item name: <input name="itemName" class="form-control" type="text"><br>
	 Item price: <input name="itemPrice" class="form-control" type="text"><br>
	 Item description: <input name="itemDesc" class="form-control" type="text"><br>
	 <input name="btnSubmit" type="submit" value="Save" class="btn btn-primary">
	</form><br>
	</div>
	
	<div class="alert alert-success">
		<%
 			out.print(session.getAttribute("statusMsg"));
		%>
	</div>
	
	
	<br>
	<br>
	<%
		 Item itemObj = new Item();
		 out.print(itemObj.readItems());
	%>
	
</body>
</html>