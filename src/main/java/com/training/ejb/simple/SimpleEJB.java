package com.training.ejb.simple;

import javax.ejb.Remote;

@Remote
public interface SimpleEJB {
	public void saySomething(String name);
	
	public void doSomething(String action);
	
}
