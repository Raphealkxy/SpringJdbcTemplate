package com.timmy.entity;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {
	
	
	@Before(value="execution(* com.timmy.entity.Book.*(..))")
	public void before1()
	{
		System.out.println("before1...........");
	}
	public void test()
	{
		System.out.println("mybook............");
	}

}
