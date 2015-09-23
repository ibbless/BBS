package service.impl;

import org.junit.Test;

import com.cw.Entity.User;
import com.cw.action.UserAction;
import com.cw.service.UserDAO;
import com.cw.service.impl.UserDAOImpl;

public class LoginTest {
		@Test
		public void testLogin(){
			User user = new User("hhh", "123");
			UserDAO userDAO = new UserDAOImpl();
			
			System.out.println(userDAO.userLogin(user));
		}
		@Test
		public void testRegistry(){
			User user = new User("aaa", "123");
			UserDAO userDAO = new UserDAOImpl();
			userDAO.userRegistry(user);
		}
		@Test
		public void testAction(){
			UserAction a = new UserAction();
			System.out.println(a.Login());
		}
}
