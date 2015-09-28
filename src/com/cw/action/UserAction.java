package com.cw.action;

import java.util.List;

import com.cw.Entity.Article;
import com.cw.Entity.User;
import com.cw.service.ArticleDao;
import com.cw.service.UserDAO;
import com.cw.service.impl.ArticleDaoImpl;
import com.cw.service.impl.UserDAOImpl;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends SuperAction implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user = new User();
	UserDAO userDao = new UserDAOImpl();
	ArticleDao articleDao = new ArticleDaoImpl();
	
	public String LoginCheck(){
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		if(userDao.userLogin(user)){
			session.setAttribute("username", request.getParameter("username"));
			return "HOME";
		}
		else{
			this.addActionMessage("failed");
			return "LOGIN";
		}
	}
	public String Login(){
		return "LOGIN";
	}
	public String RegistryCheck(){

		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		if(username==""||password1==""){
			addActionMessage("�û��������벻��Ϊ��");
			return "REGISTRY_FAILED";
		}
		else if(!password1.equals(password2)){
			addActionMessage("�������벻һ��");
			return "REGISTRY_FAILED";
		}
		else if(userDao.userCheck(username)){
			addActionMessage("�û����Ѵ���");
			return "REGISTRY_FAILED";
		}
		else{
			user.setUsername(username);
			user.setPassword(password1);
			userDao.userRegistry(user);
			session.setAttribute("username", username);
			return "HOME";
		}
	}
	public String Registry(){
		return "REGISTRY";
	}
	public String Logout(){
		session.removeAttribute("username");
		return "LOGIN";
	}
	
	@Override
	public User getModel() {
		
		return this.user;
	}
		
}
