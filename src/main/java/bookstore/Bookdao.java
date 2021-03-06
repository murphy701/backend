package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bookdao {
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";

	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"jwbook","1234");
		} catch (Exception e) { e.printStackTrace(); }
		return conn;
	}
	public ArrayList<book> getAll() throws Exception {
		Connection conn = open();
		ArrayList<book> listOfBooks = new ArrayList<book>();
		String sql = "select category, name, writer, descript, price, publisher, releasedate, img, krank from book";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try(conn; pstmt; rs) {
			while(rs.next()) {
				book b = new book();
				b.setImg(rs.getString("img"));
				b.setCategory(rs.getString("category"));
				b.setName(rs.getString("name"));
				b.setDescript(rs.getString("descript"));
				b.setWriter(rs.getString("writer"));
				b.setPublisher(rs.getString("publisher"));
				b.setReleaseDate(rs.getString("releaseDate"));
				b.setPrice(rs.getInt("price"));
				b.setKrank(rs.getInt("krank"));
				listOfBooks.add(b);
			}
			return listOfBooks;
		}
	}
	public ArrayList<book> getKBestseller(String category) throws Exception {
		Connection conn = open();
		ArrayList<book> listOfBooks = new ArrayList<book>();
		PreparedStatement pstmt = conn.prepareStatement("select bookid, img, category, name, krank from book where category=? order by krank");
		pstmt.setString(1, category);
		ResultSet rs = pstmt.executeQuery();
		System.out.println(rs);
		rs.next();
		try(conn; pstmt; rs) {
			while(rs.next()) {
				book b = new book();
				b.setBookid(rs.getInt("bookid"));
				b.setName(rs.getString("name"));
				b.setImg(rs.getString("img"));
				b.setKrank(rs.getInt("krank"));
				listOfBooks.add(b);
			}
			return listOfBooks;
		}
	}
	public ArrayList<book> getABestseller(String category) throws Exception {
		Connection conn = open();
		ArrayList<book> listOfBooks = new ArrayList<book>();
		PreparedStatement pstmt = conn.prepareStatement("select bookid, img, category, name, arank from book where category=? order by arank");
		pstmt.setString(1, category);
		ResultSet rs = pstmt.executeQuery();
		System.out.println(rs);
		rs.next();
		try(conn; pstmt; rs) {
			while(rs.next()) {
				book b = new book();
				b.setBookid(rs.getInt("bookid"));
				b.setName(rs.getString("name"));
				b.setImg(rs.getString("img"));
				b.setArank(rs.getInt("arank"));
				listOfBooks.add(b);
			}
			return listOfBooks;
		}
	}
	public ArrayList<book> getPBestseller(String category) throws Exception {
		Connection conn = open();
		ArrayList<book> listOfBooks = new ArrayList<book>();
		PreparedStatement pstmt = conn.prepareStatement("select bookid, img, category, name, prank from book where category=? order by prank");
		pstmt.setString(1, category);
		ResultSet rs = pstmt.executeQuery();
		System.out.println(rs);
		rs.next();
		try(conn; pstmt; rs) {
			while(rs.next()) {
				book b = new book();
				b.setBookid(rs.getInt("bookid"));
				b.setName(rs.getString("name"));
				b.setImg(rs.getString("img"));
				b.setPrank(rs.getInt("prank"));
				listOfBooks.add(b);
			}
			return listOfBooks;
		}
	}
	public ArrayList<book> getIBestseller(String category) throws Exception {
		Connection conn = open();
		ArrayList<book> listOfBooks = new ArrayList<book>();
		PreparedStatement pstmt = conn.prepareStatement("select bookid, img, category, name, irank from book where category=? order by irank");
		pstmt.setString(1, category);
		ResultSet rs = pstmt.executeQuery();
		System.out.println(rs);
		rs.next();
		try(conn; pstmt; rs) {
			while(rs.next()) {
				book b = new book();
				b.setBookid(rs.getInt("bookid"));
				b.setName(rs.getString("name"));
				b.setImg(rs.getString("img"));
				b.setIrank(rs.getInt("irank"));
				listOfBooks.add(b);
			}
			return listOfBooks;
		}
	}
	public ArrayList<book> getYBestseller(String category) throws Exception {
		Connection conn = open();
		ArrayList<book> listOfBooks = new ArrayList<book>();
		PreparedStatement pstmt = conn.prepareStatement("select bookid, img, category, name, yrank from book where category=? order by yrank");
		pstmt.setString(1, category);
		ResultSet rs = pstmt.executeQuery();
		System.out.println(rs);
		rs.next();
		try(conn; pstmt; rs) {
			while(rs.next()) {
				book b = new book();
				b.setBookid(rs.getInt("bookid"));
				b.setName(rs.getString("name"));
				b.setImg(rs.getString("img"));
				b.setYrank(rs.getInt("yrank"));
				listOfBooks.add(b);
			}
			return listOfBooks;
		}
	}
	public book getBook(int bookid) throws SQLException{
		Connection conn = open();
		book b = new book();
		String sql = "select * from book where bookid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bookid);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		try(conn; pstmt; rs) {
			b.setImg(rs.getString("img"));
			b.setCategory(rs.getString("category"));
			b.setName(rs.getString("name"));
			b.setDescript(rs.getString("descript"));
			b.setBookid(rs.getInt("bookid"));
			b.setWriter(rs.getString("writer"));
			b.setPublisher(rs.getString("publisher"));
			b.setReleaseDate(rs.getString("releaseDate"));
			b.setPrice(rs.getInt("price"));
			pstmt.executeQuery();
			return b;
		}
	}
	public void addBook(book b) throws Exception{
		Connection conn = open();
		String sql = "insert into book(bookid, category, name, writer, descript, price, stock, soldout, publisher, releasedate, img) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try(conn; pstmt) {
			pstmt.setInt(1, b.getBookid());
			pstmt.setString(2, b.getCategory());
			pstmt.setString(3, b.getName());
			pstmt.setString(4, b.getWriter());
			pstmt.setString(5, b.getDescript());
			pstmt.setInt(6, b.getPrice());
			pstmt.setInt(7, b.getStock());
			pstmt.setString(8, b.getSoldout());
			pstmt.setString(9, b.getPublisher());
			pstmt.setString(10, b.getReleaseDate());
			pstmt.setString(11, b.getImg());			
			pstmt.executeUpdate();
		}
	}
	public void delBook(int bookid) throws SQLException{
		Connection conn = open();
		String sql = "delete from book where bookid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try(conn; pstmt) {
			pstmt.setInt(1, bookid);
			if(pstmt.executeUpdate()==0) {
				throw new SQLException("DB??????");
			}
		}
	}

}
