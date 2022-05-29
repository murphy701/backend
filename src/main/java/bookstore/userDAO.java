package bookstore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class userDAO {
	Connection conn=null;
	PreparedStatement pstmt;
	
	final String JDBC_DRIVER="org.h2.Driver";
	final String JDBC_URL="jdbc:h2:tcp://localhost/~/jwbookdb";
	
	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(JDBC_URL, "jwbook", "1234");
		}catch(Exception e) {e.printStackTrace();}
	}
	public void close() {
		try {
			pstmt.close();
			conn.close();
		}catch(SQLException e) {e.printStackTrace();}
	}
	
	public void insert(userdb u) {
		open();
		String sql=
				"INSERT INTO userdb(name, id, call, address, email) values(?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getId());
			pstmt.setString(3, u.getCall());
			pstmt.setString(4, u.getAddress());
			pstmt.setString(5, u.getEmail());
			
			pstmt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
}
