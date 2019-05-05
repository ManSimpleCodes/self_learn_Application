package com.sehw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sehw.service.UserService;
import com.sehw.util.EncryptOrDecrypt;

/**
 * Servlet implementation class UpdateAction
 */
public class UpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	  UserService service=new UserService();
	  String password=req.getParameter("password");
	  
	  String pass=EncryptOrDecrypt.encryptText(password);
  String first=req.getParameter("firstname");
  String last=req.getParameter("lastname");
  String user=req.getParameter("username");
  boolean status=service.checkPassword(pass,user);
  System.out.println("status---"+true);
  if(status==true)
  {
	  System.out.println("in side true");
  int i=service.updateProfile(first,last,user);
  resp.sendRedirect("EditProfile?status=Successfully Updated");
  }
  else
  {
	  System.out.println("in side false");
	  resp.sendRedirect("EditProfile?status=Please Enter Correct Password");
  }
    
  
  
  }

}
