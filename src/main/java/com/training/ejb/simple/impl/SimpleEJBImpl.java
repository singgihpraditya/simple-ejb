package com.training.ejb.simple.impl;

import javax.ejb.Stateless;

import com.training.ejb.simple.SimpleEJB;

@Stateless(mappedName = "SimpleEJBImpl", name = "SimpleEJBImpl")
public class SimpleEJBImpl implements SimpleEJB {

	public void saySomething(String name) {
		System.out.println("hellooo" + name + "from EJB");
	}

	public void doSomething(String action) {
		System.out.println(action + "sekarang");

	}

}
