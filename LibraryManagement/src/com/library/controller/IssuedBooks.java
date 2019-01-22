package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.entity.Book;
import com.library.service.LibMgmtServiceImpl;

@WebServlet("/IssuedBooks")
public class IssuedBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibMgmtServiceImpl service = new LibMgmtServiceImpl();
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("username");
		List<Book> bookIssued = new ArrayList<Book>();
		try {
			bookIssued = service.issuedBook(user);
		} catch (SQLException|NullPointerException e ) {
			String error = "Unable to Connect with Database";
			request.setAttribute("error", error);
		}
		request.setAttribute("book", bookIssued);
		request.getRequestDispatcher("IssuedBooks.jsp").forward(request, response);
	}

}
