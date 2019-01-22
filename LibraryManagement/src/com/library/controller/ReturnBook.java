package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.service.LibMgmtServiceImpl;

@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibMgmtServiceImpl service = new LibMgmtServiceImpl();
		String bookId = request.getParameter("bookId");
		String username = request.getParameter("username");
		try {
			service.returnBook(bookId,username);
		} catch (SQLException|NullPointerException e ) {
			String error = "Unable to Connect with Database";
			request.setAttribute("error", error);
		}
		request.getRequestDispatcher("Home.jsp").forward(request, response);
		
	}
}
