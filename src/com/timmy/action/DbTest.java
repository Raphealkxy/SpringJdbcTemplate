package com.timmy.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mysql.jdbc.Wrapper;
import com.timmy.entity.User;

class mywrapper implements RowMapper<User>
{

	@Override
	public User mapRow(ResultSet resultSet, int index) throws SQLException {
		// 1 从结果集里面把数据得到
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				
				// 2 把得到数据封装到对象里面
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
		return user;
	}
	
}
public class DbTest {
	
	@Test
	public void add()
	{
		//设置数据库信息
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///springdemo");
		dataSource.setUsername("root");
		dataSource.setPassword("kxy1277609958");
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="insert into user value(?,?)";
		int row=jdbcTemplate.update(sql,"lucy","250");
		System.out.println(row);
	}
	
	@Test
	public void delete()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///springdemo");
		dataSource.setUsername("root");
		dataSource.setPassword("kxy1277609958");
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="delete from user where username=?";
		int row=jdbcTemplate.update(sql,"lucy");
		System.out.println(row);
	}
	
	
	@Test
	public void update()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///springdemo");
		dataSource.setUsername("root");
		dataSource.setPassword("kxy1277609958");
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		String sql="update user set password=? where username=?";
		int row=jdbcTemplate.update(sql,"1314","lucy");
		System.out.println(row);
	}
	
	@Test//返回对象
	public void query()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///springdemo");
		dataSource.setUsername("root");
		dataSource.setPassword("kxy1277609958");
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
//		String sql="select * from user where username=?";
//		User user=jdbcTemplate.queryForObject(sql, new mywrapper(),"lucy");
//		System.out.println(user);
		String sql="select * from user ";
		List<User> users=(List<User>) jdbcTemplate.query(sql, new mywrapper());
		System.out.println(users);
		

	}
	
	

}
