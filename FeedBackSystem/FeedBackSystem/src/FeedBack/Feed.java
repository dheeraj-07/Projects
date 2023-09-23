package FeedBack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Feed {
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	Feed(int rollno,int studentid,String facname,String facsubject,String feedback) throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty1","root","");
		String query="insert into feedbacktable (rollno,studentid,facname,facsubject,feedback) values (?,?,?,?,?)";
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1,rollno );
		pstmt.setInt(2, studentid);
		pstmt.setString(3, facname);
		pstmt.setString(4, facsubject);
		pstmt.setString(5, feedback);
		pstmt.executeUpdate();
		con.close();
	}
}