package com.sehw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sehw.beans.RegistrationBean;
import com.sehw.service.UserService;

/**
 * Servlet implementation class EditProfile
 */
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	  UserService service=new UserService();
  HttpSession hs=req.getSession();
  
  String status=req.getParameter("status");
  String uid=(String)hs.getAttribute("uid");
  RegistrationBean rb=service.getProfile(uid);
  hs.setAttribute("profile", rb);
  resp.sendRedirect("EditProfile.jsp?status="+status);
  }

}
