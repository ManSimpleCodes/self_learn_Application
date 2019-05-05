package com.sehw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sehw.service.UserService;


public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
/* (non-Javadoc)
 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 */
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String question=req.getParameter("question");
	String hint=req.getParameter("hint");
	String answer=req.getParameter("answer");
	//String feedback=req.getParameter("feedback");
	UserService service=new UserService();
	int i=service.uploadQuestion(question,hint,answer);
	
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
