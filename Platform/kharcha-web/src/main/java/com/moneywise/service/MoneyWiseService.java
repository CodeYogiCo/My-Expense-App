package com.moneywise.service;


import java.sql.SQLException;

import com.moneywise.model.Inmates;

public interface MoneyWiseService {
	
	public void addInmates(Inmates inmate);
	
	
	public Inmates showInmateDetails(String inmateName)throws ClassNotFoundException, SQLException ;


	public String alertInmate(String inmatesName)  throws ClassNotFoundException, SQLException;

}
