package com.lib.dao;

import java.awt.print.Book;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lib.entity.Members;

public class LibraryDaoImpl implements LibraryDao {

	public boolean getLogin(Members mem) throws SQLException {
		
		Connection conn = null;
		conn = com.lib.dao.Connection.getCon();
		String sql = "SELECT id,password FROM member where id=? and password=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, mem.getUserid());
		ps.setString(2, mem.getPassword());
	    ResultSet rs = ps.executeQuery();
	    
	    if(rs.next()){
	    	return true;
	    }
	    else{
	    	return false;
	    }
	}

	public void showAll(int bookId) {
		// TODO Auto-generated method stub

	}

	public List<Book> having(int userId) {
		List<Book> books = new ArrayList<Book>();
		return books;
		// TODO Auto-generated method stub
	}
	

	public Member myDetails(int userId) {
		// TODO Auto-generated method stub
		return null;
	}


	public void bookDates(Date issueDate, Date returnDate) {
		// TODO Auto-generated method stub
		
	}




}
