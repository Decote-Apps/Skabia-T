package com.decote.skabiat.dao;

import java.util.HashSet;
import java.util.Set;

import com.decote.skabiat.model.Bar;

public class BarFinderInMemoryDao implements IBarFinderDao {
	
	private Set <Bar> barList;
	
	public BarFinderInMemoryDao() {
		barList = new HashSet<Bar>();
	}

	@Override
	public Bar getBarById(String id) {
		Bar bar = findBar(id);
//		System.out.println(bar);
		return bar;
	}

	private Bar findBar(String id) {
		for (Bar eachBar : barList){
			if (eachBar.getId().equals(id)){
				return eachBar;
			}
		}
		return null;
	}

	@Override
	public void addBar(Bar bar) {
//		System.out.println(bar);
		barList.add(bar);
		
	}

}
