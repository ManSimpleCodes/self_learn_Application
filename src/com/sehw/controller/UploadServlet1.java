package com.sehw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sehw.beans.Questions;
import com.sehw.service.UserService;


public class UploadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
/* (non-Javadoc)
 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 */
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String question=req.getParameter("question");
	String hint=req.getParameter("hint");
	String answer=req.getParameter("answer");
	String opt1=req.getParameter("option1");
	String opt2=req.getParameter("option2");
	String opt3=req.getParameter("option3");
	String opt4=req.getParameter("option4");
	
	Questions q=new Questions();
	q.setQuestion(question);
	
	if(answer.equals("1"))
	{
		q.setAnswer(req.getParameter("option1"));
	}
	else if(answer.equals("2"))
	{
		q.setAnswer(req.getParameter("option2"));
	}
		
	else if(answer.equals("3"))
	{
		q.setAnswer(req.getParameter("option3"));
	}
	else if(answer.equals("4"))
	{
		q.setAnswer(req.getParameter("option4"));
	}
	
	q.setOption1(opt1);
	q.setOption2(opt2);
	q.setOption3(opt3);
	q.setOption4(opt4);
	q.setHint(hint);
	q.setType("M");
	
	UserService service=new UserService();
	int i=service.uploadQuestion1(q);
	
	if(i==1)
	{
		resp.sendRedirect("UploadQuestions.jsp?status=Successfully Uploaded");
	}
	else
	{
		resp.sendRedirect("UploadQuestions.jsp?status= Uploaded Failed");
	}
}
}
