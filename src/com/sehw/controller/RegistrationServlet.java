package com.sehw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sehw.beans.RegistrationBean;
import com.sehw.service.UserService;
import com.sehw.util.EncryptOrDecrypt;

public class RegistrationServlet extends HttpServlet 
{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "Registration.jsp?status=Registration Failed  !!!!!";
		
		UserService service =new UserService();

		
		RegistrationBean rb = new RegistrationBean();
	
		if(!request.getParameter("password").equals(request.getParameter("confirmPassword")))
				{
			target = "Registration.jsp?status=Password and Confirm didn't Match";
				}
		else
		{
		rb.setFirstName(request.getParameter("firstName"));
		rb.setLastName(request.getParameter("lastName"));
		
		rb.setUserName(request.getParameter("userName"));
		
		String pass=EncryptOrDecrypt.encryptText(request.getParameter("password"));
		
		System.out.println("encrypted text--------"+pass);
		rb.setPassword(pass);
		
		boolean flag1 = service.checkLoginIDExisted(request.getParameter("userName"));
		
		if (flag1 == true) {
			target = "Registration.jsp?status=" + request.getParameter("userName")
					+ "  Already Registered";
		} else {	

			boolean f1 = service.insertUserInfo(rb);
	
			if (f1 == true) {
				target = "Login.jsp?status="+request.getParameter("userName")+" Account created successfully";
			} else {
				target = "Registration.jsp?status=Registration Failed  !!!!!";
			}
		}
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	
	}
}
