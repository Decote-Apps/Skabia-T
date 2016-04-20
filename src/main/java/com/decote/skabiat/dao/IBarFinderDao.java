package com.decote.skabiat.dao;

import com.decote.skabiat.exception.UserNotFoundException;
import com.decote.skabiat.model.Bar;

public interface IBarFinderDao {
	
	public Bar getBarById(String id) throws UserNotFoundException;
	
	public void addBar (Bar bar);
	
	public void deleteBar (String id);

}
