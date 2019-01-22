package com.lib.servlets;

import java.io.IOException;
import java.lang.reflect.Member;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.entity.Members;
import com.lib.service.LibraryServiceImpl;

@WebServlet("/Login")
public class Login extends HttpServlet {

	LibraryServiceImpl method = new LibraryServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("userId");
		String password = req.getParameter("password");
		Members mem = new Members();
		mem.setUserid(id);
		mem.setPassword(password);
		try {
			boolean value = method.login(mem);
			System.out.println(value);
			if(value){
				req.getRequestDispatcher("/Wel.jsp").forward(req, resp);
			}
			else{
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
