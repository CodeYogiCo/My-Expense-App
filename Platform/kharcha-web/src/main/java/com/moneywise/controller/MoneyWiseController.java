package com.moneywise.controller;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangofactory.swagger.plugin.EnableSwagger;
import com.moneywise.model.Inmates;
import com.moneywise.service.MoneyWiseService;



@EnableSwagger
@RestController
@PropertySource("file:C:/users/kusha/properties/jdbc.properties")
public class MoneyWiseController {

	
	Logger logger= Logger.getLogger(MoneyWiseController.class);

	@Resource
	private Environment environment;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Autowired
	private MoneyWiseService moneywiseService;


	@RequestMapping("/greeting")
	public String greeting() {
		logger.debug("Inside default controller");
		return "Hello World";
	}

	@RequestMapping("/inmates/{inmatesName}")
	public Inmates saveInmatesDetails(@PathVariable String inmatesName) throws ClassNotFoundException, SQLException{
		return  moneywiseService.showInmateDetails(inmatesName);

	}
	@RequestMapping("alertEmail/{inmatesName}")
	public String alertInmates(@PathVariable String inmatesName) throws ClassNotFoundException, SQLException{
		return moneywiseService.alertInmate(inmatesName);


	}

}