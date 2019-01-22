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
import com.library.entity.User;
import com.library.service.LibMgmtServiceImpl;

@WebServlet("/FindUser")
public class FindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibMgmtServiceImpl service = new LibMgmtServiceImpl();
		List<User> user = new ArrayList<User>();
		String username = request.getParameter("username");
		try {
			user = service.findUser(username);
		} catch (SQLException|NullPointerException e ) {
			String error = "Unable to Connect with Database";
			request.setAttribute("error", error);
		}
		request.setAttribute("user", user);
		request.getRequestDispatcher("userDetails.jsp").forward(request, response);
	}

}
