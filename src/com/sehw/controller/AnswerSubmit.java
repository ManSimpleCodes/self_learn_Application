package com.sehw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sehw.service.UserService;

/**
 * Servlet implementation class AnswerSubmit
 */
public class AnswerSubmit extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	UserService service=new UserService();
	int id=Integer.parseInt(req.getParameter("qid"));
	String answer=req.getParameter("answer");
	HttpSession hs=req.getSession(false);
	
	String user=(String)hs.getAttribute("uid");
	System.out.println("username---"+user);
	
	String status=service.checkAnswer(id,answer);
	System.out.println("status--------"+status);
		
	if(status.equals("true"))
	{
		service.saveAnswer(id,user);
	}
	
	resp.sendRedirect("QuestionShow.jsp?qid="+id+"&status="+status);
	
	
}
       
   
}
