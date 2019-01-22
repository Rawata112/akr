package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.entity.User;
import com.library.service.LibMgmtServiceImpl;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LibMgmtServiceImpl service = new LibMgmtServiceImpl();
    String i;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		
		try {
			i = service.login(user);
		} catch (SQLException|NullPointerException |ClassNotFoundException e) {
			String error = "Unable to Connect with Database";
			request.setAttribute("error", error);
		}finally {
		if(i.equals(user.getId())) {
			request.setAttribute("user", user);
			HttpSession session=request.getSession();
			session.setAttribute("username",user.getId());
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		else{
			request.setAttribute("errorMessage", "Invalid user or password");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		}
	}

}
