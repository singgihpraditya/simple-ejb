package com.training.ejb.simple.test;

import java.util.Hashtable;
import java.util.List;

import com.training.ejb.simple.SimpleDataSourceAccess;
import com.training.ejb.simple.util.ServiceFactory;

public class TestSimpleDataSourceAccess {

	public static void main(String[] args) {
		String simpleDataSourceAccessJNDIName =
				"SimpleDataSourceAccessImpl#com.training.ejb.simple.SimpleDataSourceAccess";
		
		ServiceFactory serviceFactory = new ServiceFactory();
		try{
			SimpleDataSourceAccess simpleDataSourceAccess = 
					(SimpleDataSourceAccess) serviceFactory.getService(simpleDataSourceAccessJNDIName);
			boolean isAbleToConnect = simpleDataSourceAccess.isConnected();
			System.out.println("is Able to connect " + isAbleToConnect);
			
			//test database
			String name = "agus";
			String jobPosition = "junior programmer";
			String division = "java";
			
			simpleDataSourceAccess.insertPesertaTraining(name, jobPosition, division);
			
			List<Hashtable<String, String>> daftarPesertaTraining = simpleDataSourceAccess.getPesertaTraining();
			for(Hashtable<String, String> pesertaTraining: daftarPesertaTraining){
				System.out.println("id            :" + pesertaTraining.get("id") );
				System.out.println("name          :" + pesertaTraining.get("name") );
				System.out.println("job position  :" + pesertaTraining.get("jobPosition") );
				System.out.println("division      :" + pesertaTraining.get("division") );
			}
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}
