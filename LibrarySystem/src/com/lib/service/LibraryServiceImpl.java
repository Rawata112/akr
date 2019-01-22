package com.lib.service;

import java.awt.print.Book;
import java.lang.reflect.Member;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.lib.dao.LibraryDaoImpl;
import com.lib.entity.Members;

public class LibraryServiceImpl implements LibraryService{

	LibraryDaoImpl Dao = new LibraryDaoImpl();
	public boolean login( Members mem) throws SQLException{
		return Dao.getLogin(mem);
	}
	
	public void showAll(int bookId){
		Dao.showAll(bookId);
	}
	
	public List<Book> having(int userId){
		return Dao.having(userId);
		
	}
	public Member mydetails(int userId){
		return Dao.myDetails(userId);
	}
	
	public void bookDates(Date issueDate, Date returnDate){
		Dao.bookDates(issueDate,returnDate);
	}
}

