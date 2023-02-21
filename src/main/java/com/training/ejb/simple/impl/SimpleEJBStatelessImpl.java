package com.training.ejb.simple.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.training.ejb.simple.SimpleEJBStateless;

@Stateless(mappedName = "SimpleEJBStatelessImpl", name = "SimpleEJBStatelessImpl")
public class SimpleEJBStatelessImpl implements SimpleEJBStateless {
	private List<String> items;

	public SimpleEJBStatelessImpl() {
		items = new ArrayList<String>();
	}

	public void addItem(String item) {
		System.out.println("Add item : " + item);
		items.add(item);
	}

	public List<String> getAllItems() {
		System.out.println("get All Items");
		return items;
	}

}
