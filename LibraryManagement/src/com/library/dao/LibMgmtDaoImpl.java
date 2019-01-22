package com.library.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.LogManager;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import com.library.db.DBConn;
import com.library.entity.User;
import com.mysql.cj.protocol.Resultset;
import com.library.entity.Book;

public class LibMgmtDaoImpl {
	static{
		PropertyConfigurator.configure("C:\\Users\\Virus\\eclipse-workspace\\LibraryManagement\\log4j\\log4j.properties");
	}
	static Logger logger = Logger.getLogger(LibMgmtDaoImpl.class);
	public String UserAuth(User user) throws SQLException,NullPointerException{
		Connection conn = null;
		conn = DBConn.connect();
		String sql = "SELECT id,password FROM user where id=? and password=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getId());
		ps.setString(2, user.getPassword());
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()){
	    	String id = rs.getString("id");
	    	logger.info("Credentials Fetched from SQL Database for " + id );
	    	return id;
	     }
	    logger.error("User not found");
		return "User Not Found";
	}
	
	public List<Book> showBook() throws SQLException,NullPointerException{
		Connection conn = null;
		conn = DBConn.connect();
		String sql = "SELECT * FROM book where available>0";
		Statement st = conn.createStatement();
	    ResultSet rs = st.executeQuery(sql);
	    List<Book> books = new ArrayList<Book>();
	    while(rs.next()){
	    	Book book = new Book();
	    	book.setBookId(rs.getInt("BookId"));
	    	book.setBookName(rs.getString("BookName"));
	    	book.setPrice(rs.getInt("Price"));
	    	book.setAvailable(rs.getInt("available"));
	    	book.setPublisher(rs.getString("publisher"));
	    	book.setWriter(rs.getString("writer"));
	    	books.add(book);
	     }
	    logger.info("Books Fetched from database");
		return books;
	}
	
	public List<Book> showBooks() throws SQLException,NullPointerException{
		Connection conn = null;
		conn = DBConn.connect();
		String sql = "SELECT bookname,COUNT(bookId) FROM book group by bookName";
		Statement st = conn.createStatement();
	    ResultSet rs = st.executeQuery(sql);
	    List<Book> bookStock = new ArrayList<Book>();
	    while(rs.next()){
	    	Book book = new Book();
	    	book.setBookName(rs.getString("BookName"));
	    	book.setAvailable(rs.getInt("COUNT(bookId)"));
	    	bookStock.add(book);
	     }
	    logger.info("Book Fetch from database");
		return bookStock;
	}
	
	public List<Book> findBook(String BookName) throws SQLException,NullPointerException {
		Connection conn = null;
		conn = DBConn.connect();
		String sql = "SELECT * FROM book where bookName LIKE ?";
		PreparedStatement pst = conn.prepareStatement(sql);
	    pst.setString(1,BookName +'%');
		ResultSet rs = pst.executeQuery();
		List<Book> bookDetails = new ArrayList<Book>();
	    while(rs.next()){
	    	Book book = new Book();
	    	book.setBookId(rs.getInt("BookId"));
	    	book.setBookName(rs.getString("BookName"));
	    	book.setPublisher(rs.getString("publisher"));
	    	book.setPrice(rs.getInt("price"));
	    	book.setWriter(rs.getString("writer"));
	    	bookDetails.add(book);
	     }
	    logger.info("Searching Book");
	    return bookDetails;
	}
	
	public List<User> findUser(String username) throws SQLException,NullPointerException{
		Connection conn = null;
		conn = DBConn.connect();
		String sql = "SELECT * FROM user where id LIKE ?";
		PreparedStatement pst = conn.prepareStatement(sql);
	    pst.setString(1,username +'%');
		ResultSet rs = pst.executeQuery();
		List<User> UserDetails = new ArrayList<User>();
	    while(rs.next()){
	    	User user = new User();
	    	user.setId(rs.getString("id"));
	    	user.setFirst(rs.getString("First"));
	    	user.setLast(rs.getString("Last"));
	    	user.setType(rs.getInt("type"));
	    	user.setJoining(rs.getDate("joining"));
	    	UserDetails.add(user);
	     }
	    logger.info("Searching Users");
	    return UserDetails;
	}

	public void BookIssue(String bookId,String username)throws SQLException,NullPointerException {
		Connection conn = null;
		conn = DBConn.connect();
		String sql = "insert into transaction values(?,?,CURDATE(),?,'Open')";
		String sql1 = "select type from user where id=?";
		String sql2 = "update book set available=available-1 where bookId=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		PreparedStatement pst1 = conn.prepareStatement(sql1);
		PreparedStatement pst2 = conn.prepareStatement(sql2);
		pst1.setString(1, username);
		pst2.setString(1, bookId);
		ResultSet rs = pst1.executeQuery();
		Date returnDate = null;
		Date current = new java.sql.Date(new java.util.Date().getTime());
		while(rs.next()){
			int type = rs.getInt(1);
			if(type==2){
				returnDate = addDays(current, 7);
			}else if(type==1){
				returnDate = addDays(current, 15);
			}
			else
			{
				returnDate = addDays(current, 30);
			}
		}
	    pst.setString(2,bookId);
	    pst.setString(1,username);
	    pst.setDate(3, returnDate);
	    pst.execute();
	    pst2.execute();
	    logger.info("Issuing book");
	}
	public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        logger.info("return date calculate");
        return new Date(c.getTimeInMillis());
    }

	public List<Book> issuedBook(String user)throws SQLException,NullPointerException {
		Connection conn = null;
		conn = DBConn.connect();
		String sql = "SELECT * FROM transaction where id=? and status!='Closed'";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, user);
	    ResultSet rs = pst.executeQuery();
	    List<Book> books = new ArrayList<Book>();
	    while(rs.next()){
	    	Book book = new Book();
	    	book.setBookId(rs.getInt("BookId"));
	    	books.add(book);
	     }
		return books;
	}

	public void returnBook(String bookId, String username)throws SQLException,NullPointerException {
		Connection conn = null;
		conn = DBConn.connect();
		String sql = "update transaction set status='Closed' where BookId=?";
		String sql1 = "insert into transaction values(?,?,CURDATE(),CURDATE(),'Closed')";
		String sql2 = "update book set available= available + 1 where bookId=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		PreparedStatement pst1 = conn.prepareStatement(sql1);
		PreparedStatement pst2 = conn.prepareStatement(sql2);
		pst1.setString(1, username);
		pst1.setString(2, bookId);
		pst.setString(1, bookId);
		pst2.setString(1, bookId);
	    pst.execute();
	    pst1.execute();
	    pst2.execute();
	}

	public List<Book> bookNotAvailable() throws SQLException,NullPointerException  {
		Connection conn = null;
			conn = DBConn.connect();
			String sql = "SELECT * FROM book where available<0";
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery(sql);
		    List<Book> books = new ArrayList<Book>();
		    while(rs.next()){
		    	Book book = new Book();
		    	book.setBookId(rs.getInt("BookId"));
		    	book.setBookName(rs.getString("BookName"));
		    	book.setPrice(rs.getInt("Price"));
		    	book.setAvailable(rs.getInt("available"));
		    	book.setPublisher(rs.getString("publisher"));
		    	book.setWriter(rs.getString("writer"));
		    	books.add(book);
		     }
		    return books;
	}
}
