package FeedBack;
import java.sql.*;
import java.util.ArrayList;
public class importFacName{
	static ArrayList<String> getList() throws SQLException,ClassNotFoundException{
		ArrayList<String> al=new ArrayList();
		
		Connection con=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty1","root","");
		stmt=con.createStatement();
		String query="select name from fac";
		ResultSet rset=stmt.executeQuery(query);
		while(rset.next()) {
			al.add(rset.getString("name"));
			
		}
		return al;
		}
	}