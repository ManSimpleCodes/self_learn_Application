package com.sehw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.sehw.beans.Questions;
import com.sehw.beans.RegistrationBean;
import com.sehw.util.DBConnectionClass;

public class UserDAO extends DBConnectionClass
{

	public static Connection con;
	PreparedStatement ps,pst;
	private boolean flag;

	public UserDAO() {
		con = getConnection();

	}
	
	public boolean checkLoginIDExisted(String userName) 
	{
		boolean f = false;
		try {
			
			ps = con
					.prepareStatement("select username from users where username=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
			ps.close();
		rs.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}

	public boolean insertUserInfo(RegistrationBean reb) {
		String first=reb.getFirstName();
		String userName=reb.getUserName();
		String pass=reb.getPassword();
		String last=reb.getLastName();
		String role="USER";		
		try {
			int i = 0;
			
			pst = con
					.prepareStatement("insert into users(first_name,last_name,username,password,role) values(?,?,?,?,?)");
			pst.setString(1, first);
			pst.setString(2, last);
			pst.setString(3, userName);
			pst.setString(4, pass);
			pst.setString(5, role);
			
			i = pst.executeUpdate();
			if (i == 1) {
				flag = true;
				
			} else {
				flag = false;
				
			}
			pst.close();
			con.close();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			
			
		}  
		return flag;
	}

	public RegistrationBean loginCheck(RegistrationBean regbean) {
		String userName = regbean.getUserName();
		String password = regbean.getPassword();
		RegistrationBean regbean1 = new RegistrationBean();
		try {
			
			pst = con
			.prepareStatement("select role,username from USERS where username=? and password=?");
			pst.setString(1, userName);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				regbean1.setUserType(rs.getString(1));
				regbean1.setUserName(rs.getString(2));
				
			} else {
				flag = false;
				regbean1.setUserType("");
				
				
				
				regbean1.setUserName("");
			}
			pst.close();
			con.close();
		} catch (SQLException ex) {
		
			
			flag = false;
		} 

		return regbean1;
	}

	public int uploadQuestion(String question, String hint, String answer) 
	{
		int i=0,count=0;
		
		try
		{
			pst=con.prepareStatement("select max(id) from questions");
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
			}
			rs.close();
			pst.close();
			
			pst=con.prepareStatement("insert into questions(question,hint,answer,id,type) values(?,?,?,?,?)");
			pst.setString(1, question);
			pst.setString(2, hint);
			pst.setString(3, answer);
			pst.setInt(4, count+1);
			pst.setString(5, "N");
			//pst.setString(6, feedback);
			i=pst.executeUpdate();
			pst.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
		
	}

	public int uploadQuestion1(Questions q)
	{
		
		int i=0,count=0;
		
		try
		{
			pst=con.prepareStatement("select max(id) from questions");
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
			}
			rs.close();
			pst.close();
			
			pst=con.prepareStatement("insert into questions(question,hint,answer,id,option1,option2,option3,option4,type) values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1, q.getQuestion());
			pst.setString(2, q.getHint());
			pst.setString(3, q.getAnswer());
			pst.setInt(4, count+1);
			pst.setString(5, q.getOption1());
			pst.setString(6, q.getOption2());
			pst.setString(7, q.getOption3());
			pst.setString(8, q.getOption4());
			pst.setString(9, q.getType());
		//	pst.setString(10, q.getFeedBack());
			i=pst.executeUpdate();
			pst.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public HashMap viewQuestions() 
	{
		int i=0;
		HashMap hm=new HashMap();
		
		try
		{
			
			pst=con.prepareStatement("select id,question,type from questions");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				i=i+1;
				Questions q=new Questions();
				q.setId(rs.getInt(1));
				q.setQuestion(rs.getString(2));
				q.setType(rs.getString(3));
				hm.put(i, q);
			}
			rs.close();
			pst.close();
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hm;
	}
		
	public Questions getQuestion(int id)
	{
		Questions q=new Questions();
		try
		{
			
			pst=con.prepareStatement("select * from questions where id=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				
				q.setId(rs.getInt(1));
				q.setQuestion(rs.getString(2));
				q.setHint(rs.getString(3));
				q.setAnswer(rs.getString(4));
				q.setOption1(rs.getString(5));
				q.setOption2(rs.getString(6));
				q.setOption3(rs.getString(7));
				q.setOption4(rs.getString(8));
				q.setType(rs.getString(9));
				
			}
			rs.close();
			pst.close();
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return q;
		
		
	}

	public String checkAnswer(int id, String answer) 
	{
		String status="false";
		String ans=answer.toUpperCase();
		System.out.println("answer----"+ans);
		try
		{
			
			pst=con.prepareStatement("select * from questions where id=? and UPPER(answer)=?");
			pst.setInt(1, id);
			pst.setString(2,ans);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				
			status="true";
			}
			rs.close();
			pst.close();
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}

	public void saveAnswer(int id, String user) {
		boolean status=false;
		try
		{
			pst=con.prepareStatement("select * from answers where id=? and user=?");
			pst.setInt(1,id);
			pst.setString(2,user);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				status=true;
			}
			rs.close();
			pst.close();
			
			if(status==false)
			{
			pst=con.prepareStatement("insert into answers(id,user) values(?,?)");
			pst.setInt(1, id);
			pst.setString(2, user);
			pst.executeUpdate();
			pst.close();
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public String checkQ(int id,String uid)
	{

		String status="false";
		try
		{
			pst=con.prepareStatement("select * from answers where id=? and user=?");
			pst.setInt(1,id);
			pst.setString(2,uid);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				status="true";
			}
			rs.close();
			pst.close();
		
	}
	catch(Exception e)
		{
		e.printStackTrace();
		}
		return status;
	}

	public String clearHistory(String uid) 
	{
		String status="false";
		int i=0;
		try
		{
			pst=con.prepareStatement("delete from answers where user=?");
			pst.setString(1, uid);

			i=pst.executeUpdate();
			if(i>0)
			{
				status="true";
			}
			
			pst.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	public RegistrationBean getProfile(String uid) 
	{
		RegistrationBean rb=new RegistrationBean();
		try
		{
			pst=con.prepareStatement("select * from users where username=?");
			pst.setString(1,uid);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				rb.setFirstName(rs.getString(1));
				rb.setLastName(rs.getString(2));
				rb.setUserName(rs.getString(3));
				
			}
			rs.close();
			pst.close();
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	return rb;
	}

	public int updateProfile(String first, String last, String user) 
	{
		int i=0;
		try
		{
			pst=con.prepareStatement("update users set first_name=?,last_name=? where username=?");
			pst.setString(1, first);
			pst.setString(2, last);
			pst.setString(3, user);
			i=pst.executeUpdate();
			pst.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public boolean changePassword(String userid, String old, String newpass) {
		boolean status=false;
		int i=0;
		try
		{
			pst=con.prepareStatement("update users set password=?  where username=? and password=?");
			pst.setString(1, newpass);
			pst.setString(2, userid);
			pst.setString(3, old);
			i=pst.executeUpdate();
			if(i==1)
			{
				status=true;
			}
			pst.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}

	public boolean checkPassword(String password, String user)
	{
		boolean status=false;
		try
		{
			System.out.println("username--"+user);
			System.out.println("password--"+password);
			pst=con.prepareStatement("select * from users where username=? and password=?");
			pst.setString(1, user);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println("true");
				status=true;
			}
			pst.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
////////
	public boolean checkIDExisted(int id) 
	{
		boolean f1 = false;
		try {
			
			ps = con
					.prepareStatement("select id from questions where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f1 = true;
			}
			ps.close();
		rs.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f1;
	}
}
