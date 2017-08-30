package com.timmy.entity;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public void add(String name,String password)
	{
		String sql="insert into user values(?,?)";
		jdbcTemplate.update(sql,name,password);
		System.out.println("插入成功");
	}
	public void test()
	{
		System.out.println("userdao............");
	}

}
