package com.moneywise.repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource("file:C:/users/kusha/properties/jdbc.properties")

public class DatabaseConfiguration {
	
	@Resource
	private Environment environment;
	
	@Bean
	public DataSource datasource(){
		BoneCPDataSource dataSource= new BoneCPDataSource();
		dataSource.setDriverClass(environment.getRequiredProperty("driverName"));
		dataSource.setJdbcUrl(environment.getRequiredProperty("jdbcURL"));
		dataSource.setUsername(environment.getRequiredProperty("username"));
		dataSource.setPassword(environment.getRequiredProperty("password"));
		return dataSource;
		
	}
	@Bean
	public JdbcTemplate getjdbcTemplate(){
		JdbcTemplate jdbcTemplate= new JdbcTemplate(datasource());
		return jdbcTemplate;
	}
	
	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(){
		return new NamedParameterJdbcTemplate(datasource());
	}
}

