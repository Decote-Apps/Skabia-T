package com.decote.skabiat.dao;

import com.decote.skabiat.model.Bar;

public interface IBarFinderDao {
	
	public Bar getBar(String id);
	
	public void addBar (Bar bar);

}
