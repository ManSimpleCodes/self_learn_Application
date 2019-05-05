 package com.sehw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sehw.beans.RegistrationBean;
import com.sehw.service.UserService;
import com.sehw.util.EncryptOrDecrypt;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String utype = "";
	private String username = "";
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service=new UserService();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		RegistrationBean rb = new RegistrationBean();
		session.setAttribute("uid", request.getParameter("userName"));
		String target = "Login.jsp?status=Internal Problem Please Try again!";
		try
		{
		rb.setUserName(request.getParameter("userName"));
		
		String password=EncryptOrDecrypt.encryptText(request.getParameter("password"));
		
		
		rb.setPassword(password);
		RegistrationBean rb1 = new RegistrationBean();
		rb1 = service.loginCheck(rb);
		
		utype = rb1.getUserType();
		username = rb1.getUserName();
		
		session.setAttribute("uid", request.getParameter("userName"));
		
	 if (utype.equals("USER")) {
			
				target = "UserHome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("uid", username);
				session.setAttribute("role", utype);

		} 
		else 
		{
			target = "Login.jsp?status=Invalid username or password";
		}
		
		}
		catch(Exception e)
		{
			target = "Login.jsp?status=Invalid username or password";
		}

		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);

		out.flush();
		out.close();
	}
	

}
