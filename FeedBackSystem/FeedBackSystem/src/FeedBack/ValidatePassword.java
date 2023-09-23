package FeedBack;

import java.sql.*;
import java.util.*;
public class ValidatePassword 
{
Connection con=null;
Statement stmt=null;
static boolean state;
 
ValidatePassword()
 {
 }

boolean ValidAte(String username,String password) throws ClassNotFoundException,SQLException {
	 Scanner sc = new Scanner(System.in);
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/uname","root","");
	 stmt=con.createStatement();

	 ResultSet rs=stmt.executeQuery("SELECT * FROM passwords WHERE u_name LIKE '%"     + username + "%'");
	String temp="";
	 while(rs.next())
	 {
		temp=rs.getString("p_word");
	 }
	 con.close();
	 if(temp.equals(password)) {
		 return true;
	 }
	 else {
		 return false;
	 }
	
}
 public static void main(String[] args) {
	 try{
		 new ValidatePassword().ValidAte("Devendra","dextro19");
	 }
	 catch(Exception e)
	 { e.printStackTrace();}
 	}
}
