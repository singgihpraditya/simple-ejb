package com.training.ejb.simple.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import com.training.ejb.simple.SimpleEJBStateful;

@Stateful(mappedName = "SimpleEJBStatefulImpl", name = "SimpleEJBStatefulImpl")
public class SimpleEJBStatefulImpl implements SimpleEJBStateful {
	private List<String> items;

	public SimpleEJBStatefulImpl() {
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
