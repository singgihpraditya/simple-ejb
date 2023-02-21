package com.training.ejb.simple.test;

import com.training.ejb.simple.SimpleEJBStateful;
import com.training.ejb.simple.util.ServiceFactory;

public class TestSimpleEJBStateful {

	public static void main(String[] args) {

		String simpleEJBJNDIName = "SimpleEJBStatefulImpl#com.training.ejb.simple.SimpleEJBStateful";

		ServiceFactory serviceFactory = new ServiceFactory();
		try {
			SimpleEJBStateful simpleEJBStateFul = (SimpleEJBStateful) serviceFactory.getService(simpleEJBJNDIName);
			simpleEJBStateFul.addItem("kopi");
			simpleEJBStateFul.addItem("ice Cream");
			SimpleEJBStateful simpleEJBStateFul2 = (SimpleEJBStateful) serviceFactory.getService(simpleEJBJNDIName);
			simpleEJBStateFul2.addItem("kopiko");
			simpleEJBStateFul2.addItem("ice Cream cappucino");
			java.util.List<String> itemList = simpleEJBStateFul2.getAllItems();

			for (int i = 0; i < itemList.size(); i++) {
				System.out.println((i + 1) + " item :" + itemList.get(i));
			}
		} catch (Exception e) {
			System.err.print("Error :" + e.getMessage());

		}
	}
}
