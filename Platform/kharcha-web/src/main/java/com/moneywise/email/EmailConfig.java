package com.moneywise.email;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EmailConfig {
	
	@Resource
	private Environment environment;
	
	@Bean(name="emailProperty")
	public Properties getProperties(){
		
		Properties property= new Properties();
		property.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		property.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		property.put("mail.smtp.socketFactory.class",
	            "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		property.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		property.put("mail.smtp.port", "465"); //SMTP Port
		return property;
		
	}

}
