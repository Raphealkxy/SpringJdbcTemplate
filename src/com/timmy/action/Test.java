package com.timmy.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timmy.entity.Book;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
		Book book=(Book) context.getBean("book");
		book.add();
		
	}

}
