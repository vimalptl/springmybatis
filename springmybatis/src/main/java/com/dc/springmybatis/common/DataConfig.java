package com.dc.springmybatis.common;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


@Configuration
@MapperScan("com.dc.springmybatis.persistence")
public class DataConfig {

	@Bean
	public DataSource dataSource() {
	       BasicDataSource dataSource = new BasicDataSource();
	       dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	       dataSource.setUrl("jdbc:mysql://localhost:3306/h2manage");
	       dataSource.setUsername("root");
	       dataSource.setPassword("redtiger");
	       return dataSource;

		// populate some data
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		System.out.println("Creating tables");
//		jdbcTemplate.execute("drop table users if exists");
//		jdbcTemplate.execute("create table users(id serial, firstName varchar(255), lastName varchar(255), email varchar(255))");
//		jdbcTemplate.update("INSERT INTO users(firstName, lastName, email) values (?,?,?)", "Mike", "Lanyon", "lanyonm@gmail.com");

	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource());
//		sessionFactory.setTypeAliasesPackage("com.dc.springmybatis.bo");
	    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	    sessionFactory.setDataSource(dataSource());
	    return sessionFactory;
//		return sessionFactory;
	}
}

