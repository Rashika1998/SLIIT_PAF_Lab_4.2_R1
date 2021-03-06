package com.PAF;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Item {
	
	//connection of DB
	public Connection connect()
	{
		Connection con = null;

	 try
	 {
		 Class.forName("com.mysql.jdbc.Driver");
		 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/paf_lab_3.2","root", "issa123");
		 //For testing
		 System.out.print("Successfully connected");
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }

	 return con;
	}
	
	
	
	
	
	
	
	
	//insert data into the database
	
	public String insertItem(String code, String name, String price, String desc)
	{
		String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database";
	 }
	 // create a prepared statement
	 String query = " insert into items(`itemID`,`itemCode`,`itemName`,`itemPrice`,`itemDesc`)" + " values (?, ?, ?, ?, ?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, code);
	 preparedStmt.setString(3, name);
	 preparedStmt.setDouble(4, Double.parseDouble(price));
	 preparedStmt.setString(5, desc); 
	 //execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	catch (Exception e)
	 {
	 output = "Error while inserting";
	 System.err.println(e.getMessage());
	 }
	return output;
	}
	
	
	
	
	
	
	//read items
	public String readItems()
	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database for reading.";
	 }
	 // Prepare the html table to be displayed
	 output = "<table class='table table-bordered' border='1'><tr><th>Item Code</th>"
	 +"<th>Item Name</th><th>Item Price</th>"
	 + "<th>Item Description</th>"
	 + "<th>Update</th><th>Remove</th></tr>";
	 String query = "select * from items";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String itemID = Integer.toString(rs.getInt("itemID"));
	 String itemCode = rs.getString("itemCode");
	 String itemName = rs.getString("itemName");
	 String itemPrice = Double.toString(rs.getDouble("itemPrice"));
	 String itemDesc = rs.getString("itemDesc");
	 // Add a row into the html table
	 output += "<tr><td>" + itemCode + "</td>";
	 output += "<td>" + itemName + "</td>";
	 output += "<td>" + itemPrice + "</td>"; 
	 output += "<td>" + itemDesc + "</td>";
	 // buttons
	 output += "<td><input name='btnUpdate' "
	 + " type='button' value='Update' class='btn btn-primary'></td>"
	 + "<td><form method='post' action='items.jsp'>"
	 + "<input name='btnRemove' "
	 + " type='submit' value='Remove' class='btn btn-danger'>"
	 + "<input name='itemID' type='hidden' "
	 + " value='" + itemID + "'>" + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	catch (Exception e)
	 {
	 output = "Error while reading the items.";
	 System.err.println(e.getMessage());
	 }
	return output;
	}
	
	
	
	
	
	
	//delete item
	public String deleteItem(String itemID)
	{ 
		String output = ""; 
	try
	 { 
		Connection con = connect(); 
	 if (con == null) 
	 { 
	 return "Error while connecting to the database for deleting."; 
	 } 
		 // create a prepared statement
		 String query = "delete from items where itemID=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(itemID)); 
		 
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Deleted successfully"; 
	 } 
	catch (Exception e) 
	 { 
		 output = "Error while deleting the item."; 
		 System.err.println(e.getMessage()); 
	 } 
	return output; 
	}
	
	
	
	
	
	

}
