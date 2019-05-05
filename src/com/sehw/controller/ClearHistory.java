package com.sehw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sehw.service.UserService;

/**
 * Servlet implementation class ClearHistory
 */
public class ClearHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
  
  {
	UserService service=new UserService();
	  HttpSession hs=req.getSession();
	String uid=(String)hs.getAttribute("uid");
	String status=service.clearHistory(uid);
	resp.sendRedirect("ViewQuestions.jsp");
}

}
