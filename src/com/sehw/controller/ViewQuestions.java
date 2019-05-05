package com.sehw.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sehw.service.UserService;

/**
 * Servlet implementation class ViewQuestions
 */
public class ViewQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	   HttpSession hs=req.getSession();
	   UserService service=new UserService();
	   HashMap hm=service.viewQuestions();
	   hs.setAttribute("hm", hm);
	   resp.sendRedirect("ViewQuestions.jsp");
	   
}

}
