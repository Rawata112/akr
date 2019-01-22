package com.library.service;

import java.sql.SQLException;
import java.util.List;

import com.library.dao.LibMgmtDaoImpl;
import com.library.entity.Book;
import com.library.entity.User;

public class LibMgmtServiceImpl {
	LibMgmtDaoImpl Dao = new LibMgmtDaoImpl();
	public String login(User user) throws SQLException, ClassNotFoundException,NullPointerException {
		return Dao.UserAuth(user);
		}
	public List<Book> showBook() throws SQLException,NullPointerException {
		return Dao.showBook();
	}
	public List<Book> showBooks() throws SQLException,NullPointerException {
		return Dao.showBooks();
	}
	public List<Book> findBook(String BookName) throws SQLException,NullPointerException {
		return Dao.findBook(BookName);
	}
	public List<User> findUser(String username) throws SQLException,NullPointerException {
		return Dao.findUser(username);
	}
	public void BookIssue(String id, String username) throws SQLException,NullPointerException {
		Dao.BookIssue(id,username);
	}
	public List<Book> issuedBook(String user) throws SQLException,NullPointerException {
		return Dao.issuedBook(user);
	}
	public void returnBook(String bookId, String username) throws SQLException,NullPointerException {
		Dao.returnBook(bookId,username);
	}
	public List<Book> bookNotAvailable() throws SQLException,NullPointerException {
		return Dao.bookNotAvailable();
	}

}
