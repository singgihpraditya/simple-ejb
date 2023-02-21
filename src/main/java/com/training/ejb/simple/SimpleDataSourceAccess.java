package com.training.ejb.simple;

import java.util.Hashtable;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface SimpleDataSourceAccess {
	public boolean isConnected();
	
	public void insertPesertaTraining(String Name, String jobPosition, String division);
	public List<Hashtable<String, String>> getPesertaTraining();
}
