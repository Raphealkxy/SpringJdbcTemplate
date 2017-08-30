package com.timmy.entity;

public class UserService {
	
	
	private UserDao userDao;
	
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	public void add(String name,String password)
	{
		userDao.add(name,password);
	}

}
