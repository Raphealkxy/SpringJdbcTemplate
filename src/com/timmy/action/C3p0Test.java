package com.timmy.action;

import java.beans.PropertyVetoException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.timmy.entity.UserService;

public class C3p0Test {
	
	@Test
	public void add() 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
		UserService userService=(UserService) context.getBean("userservice");
		userService.add("孔祥月", "123456");
	}

}
