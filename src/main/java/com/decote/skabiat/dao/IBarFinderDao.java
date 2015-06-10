package com.decote.skabiat.dao;

import com.decote.skabiat.model.Bar;

public interface IBarFinderDao {
	
	public Bar getBarById(String id);
	
	public void addBar (Bar bar);
	
	public void deleteBar (String id);

}
