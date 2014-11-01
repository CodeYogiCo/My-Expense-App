package com.moneywise.service.impl;


import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneywise.model.Inmates;
import com.moneywise.repository.MoneyWiseRepository;
import com.moneywise.service.MoneyWiseService;

@Service
public class MoneyWiseServiceImpl implements MoneyWiseService{
	
	Logger logger= Logger.getLogger(MoneyWiseServiceImpl.class);
	
	@Autowired
	private MoneyWiseRepository moneyWiseRepository;
	

	public void addInmates(Inmates inmate) {
		// TODO Auto-generated method stub
		moneyWiseRepository.addInmates(inmate);
	}


	public Inmates showInmateDetails(String inmateName) throws ClassNotFoundException, SQLException {
		
		logger.debug("Inside Show Inmate Details Method in");
		// TODO Auto-generated method stub
		return moneyWiseRepository.showInmatesDetails(inmateName);
	}


	public String alertInmate(String inmatesName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return moneyWiseRepository.alertInmates( inmatesName);
	}

}
