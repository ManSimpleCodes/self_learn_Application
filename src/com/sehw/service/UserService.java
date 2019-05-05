package com.sehw.service;

import java.util.HashMap;

import com.sehw.beans.Questions;
import com.sehw.beans.RegistrationBean;
import com.sehw.dao.UserDAO;

public class UserService 
{
	UserDAO dao=new UserDAO();

	public boolean checkLoginIDExisted(String userName) {
		
		return dao.checkLoginIDExisted(userName);
	}

	public boolean insertUserInfo(RegistrationBean rb) {
		// TODO Auto-generated method stub
		return dao.insertUserInfo(rb);
	}

	public RegistrationBean loginCheck(RegistrationBean rb) {
		
		return dao.loginCheck(rb);
	}

	public int uploadQuestion(String question, String hint, String answer) {

		return dao.uploadQuestion(question,hint,answer);
	}

	public int uploadQuestion1(Questions q) {
				return dao.uploadQuestion1(q);
	}

	public HashMap viewQuestions() {
		
		return dao.viewQuestions();
	}

	public String checkAnswer(int id, String answer) {
		
		return dao.checkAnswer(id,answer);
	}

	public void saveAnswer(int id, String user) {
		dao.saveAnswer(id,user);
		
	}

	public String clearHistory(String uid) {
		// TODO Auto-generated method stub
		return dao.clearHistory(uid);
	}

	public RegistrationBean getProfile(String uid) {
		return dao.getProfile(uid);
	}

	public int updateProfile(String first, String last, String user) {
		// TODO Auto-generated method stub
		return dao.updateProfile(first,last,user);
	}

	public boolean changePassword(String userid, String old, String newpass) {
		// TODO Auto-generated method stub
		return dao.changePassword(userid,old,newpass);
	}

	public boolean checkPassword(String password, String user) {
		// TODO Auto-generated method stub
		return dao.checkPassword(password,user);
	}

}
