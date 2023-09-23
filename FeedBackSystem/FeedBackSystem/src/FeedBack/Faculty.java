package FeedBack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Faculty {
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	Faculty(String name,String subject,String designation) throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty1","root","");
		String query="insert into fac (name,subject,designation) values (?,?,?)";
		pstmt=con.prepareStatement(query);
		pstmt.setString(1,name );
		pstmt.setString(2, subject);
		pstmt.setString(3, designation);
		pstmt.executeUpdate();
		con.close();
	}
	Faculty(String name) throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty1","root","");
		String query="delete from fac where name=(?)";
		pstmt=con.prepareStatement(query);
		pstmt.setString(1,name );
		
		pstmt.executeUpdate();
		con.close();
	}
	public static void main(String[] args) {
		
	}
}
