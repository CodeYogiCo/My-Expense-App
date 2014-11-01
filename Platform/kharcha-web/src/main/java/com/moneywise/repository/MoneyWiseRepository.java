package com.moneywise.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.moneywise.email.EmailUtil;
import com.moneywise.model.Inmates;

@Repository
@PropertySource(("classpath:properties/query.properties"))
public class MoneyWiseRepository {
	
	@Qualifier("emailProperty")
	@Autowired
	private Properties property;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public boolean addInmates(Inmates inmate) {
		// TODO Auto-generated method stub
		return false;
		
	}

	@SuppressWarnings("unchecked")
	public Inmates showInmatesDetails(String inmate) throws ClassNotFoundException, SQLException {
	@SuppressWarnings("rawtypes")
	Map namedParameters= new HashMap<>();
	namedParameters.put("inmateName", inmate);
//
	
	return namedParameterJdbcTemplate.queryForObject(environment.getProperty("inmatesDetails"),namedParameters,new InmatesRowMapper());

		
	}
	public static class InmatesRowMapper implements RowMapper<Inmates>{

		@Override
		public Inmates mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Inmates inmates= new Inmates();
			inmates.setInmates_names(rs.getString("inmates_name"));
			return inmates;
		}
		
	}

	public String alertInmates(String inmatesName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.gjt.mm.mysql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.101:3306/planner", "jeffrey", "bangalore");
		PreparedStatement pstmt= connection.prepareStatement("select inmates_email from inmates_details where inmates_name=?");
		pstmt.setString(1, inmatesName);
		ResultSet rs=pstmt.executeQuery();
		rs.next();

		//jdbcTemplate.execute();


		final String fromEmail = "iveeshal@gmail.com"; //requires valid gmail id
		final String password = "Masquerade@123"; // correct password for gmail id
		final String toEmail = rs.getString("inmates_email"); // can be any email id 
		System.out.println("To Email"+toEmail);
		System.out.println("SSLEmail Start");


		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getDefaultInstance(property, auth);
		System.out.println("Session created");
		return EmailUtil.sendEmail(session, toEmail,"Vishal Testing", "Vishal Testing Body");
	}

}
