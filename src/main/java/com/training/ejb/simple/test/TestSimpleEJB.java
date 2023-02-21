package com.training.ejb.simple.test;

import com.training.ejb.simple.SimpleEJB;
import com.training.ejb.simple.util.ServiceFactory;

public class TestSimpleEJB {
	public static void main(String[] args) {
		String simpleEJBJNDIName = "SimpleEJBImpl#com.training.ejb.simple.SimpleEJB";

		ServiceFactory serviceFactory = new ServiceFactory();
		try {
			SimpleEJB simpleEJB = (SimpleEJB) serviceFactory.getService(simpleEJBJNDIName);
			simpleEJB.saySomething("agus	");
			simpleEJB.doSomething("makan");
		} catch (Exception e) {
			System.out.println("error");
		}

	}

}
