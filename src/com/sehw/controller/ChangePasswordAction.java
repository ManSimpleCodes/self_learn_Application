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


public class ChangePasswordAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
UserService service=new UserService();
response.setContentType("text/html");
PrintWriter out = response.getWriter();

HttpSession session = request.getSession();
String userid=(String)session.getAttribute("uid");
String target = "ChangePassword.jsp?status=Please enter correct old password......";
String old=request.getParameter("old");
String newpass=request.getParameter("newpass");

String oldPassword=EncryptOrDecrypt.encryptText(old);
String newPassword=EncryptOrDecrypt.encryptText(newpass);


boolean f=	service.changePassword(userid,oldPassword,newPassword);
if(f==true){
	
	target = "ChangePassword.jsp?status=Your Password has been changed ";
}
else{
	
	target = "ChangePassword.jsp?status=Please enter correct old password";
}

   RequestDispatcher rd = request.getRequestDispatcher(target);
   rd.forward(request,response);    
out.flush();
out.close();
}


public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
doGet(request,response);
response.setContentType("text/html");
PrintWriter out = response.getWriter();

out.flush();
out.close();
}
}
