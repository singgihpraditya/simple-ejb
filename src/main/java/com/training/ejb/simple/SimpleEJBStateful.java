package com.training.ejb.simple;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface SimpleEJBStateful {
	
	public void addItem(String item);
	public List<String> getAllItems();
}
