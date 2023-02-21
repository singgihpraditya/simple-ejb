package com.training.ejb.simple.test;

import com.training.ejb.simple.SimpleEJBStateless;
import com.training.ejb.simple.util.ServiceFactory;

public class TestSimpleEJBStateless {

	public static void main(String[] args) {

		String simpleEJBJNDIName = "SimpleEJBStatelessImpl#com.training.ejb.simple.SimpleEJBStateless";

		ServiceFactory serviceFactory = new ServiceFactory();
		try {
			SimpleEJBStateless simpleEJBStateless = (SimpleEJBStateless) serviceFactory.getService(simpleEJBJNDIName);
			simpleEJBStateless.addItem("kopi 1");
			simpleEJBStateless.addItem("ice Cream 11");
			SimpleEJBStateless simpleEJBStateless2 = (SimpleEJBStateless) serviceFactory.getService(simpleEJBJNDIName);
			simpleEJBStateless2.addItem("kopiko 11");
			simpleEJBStateless2.addItem("ice Cream cappucino 111");
			java.util.List<String> itemList = simpleEJBStateless2.getAllItems();

			for (int i = 0; i < itemList.size(); i++) {
				System.out.println((i + 1) + " item :" + itemList.get(i));
			}
		} catch (Exception e) {
			System.err.print("Error :" + e.getMessage());

		}

	}
}
