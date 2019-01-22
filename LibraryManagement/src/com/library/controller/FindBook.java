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

import com.library.entity.Book;
import com.library.service.LibMgmtServiceImpl;

@WebServlet("/FindBook")
public class FindBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibMgmtServiceImpl service = new LibMgmtServiceImpl();
		List<Book> book = new ArrayList<Book>();
		String bookName = request.getParameter("bookName");
		try {
			book = service.findBook(bookName);
		} catch (SQLException|NullPointerException e ) {
			String error = "Unable to Connect with Database";
			request.setAttribute("error", error);
		}
		request.setAttribute("book", book);
		request.getRequestDispatcher("bookDetails.jsp").forward(request, response);
	}
}
