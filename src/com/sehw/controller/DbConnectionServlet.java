package com.sehw.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sehw.util.DBConnectionClass;

public class DbConnectionServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig sc) throws ServletException {
		DBConnectionClass dbClass;
		ServletContext context=sc.getServletContext();
		InputStream fis=context.getResourceAsStream(sc.getInitParameter("config"));
		Properties properties=new Properties();
		try 
		{
			properties.load(fis);
		}
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		dbClass =new DBConnectionClass();
		dbClass.setProperties(properties);
	}


}
