package com.cw.service;

import com.cw.Entity.User;

public interface UserDAO {
	public boolean userLogin(User user);
	public void userRegistry(User user);
	public boolean userCheck(String username);
	public User getUserByName(String username);
	
	
}
