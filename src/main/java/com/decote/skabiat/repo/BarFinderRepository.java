package com.decote.skabiat.repo;

import com.decote.skabiat.dao.BarFinderInElasticSearchDao;
import com.decote.skabiat.dao.IBarFinderDao;
import com.decote.skabiat.exception.UserNotFoundException;
import com.decote.skabiat.model.Bar;

public class BarFinderRepository {
	
	private IBarFinderDao barDao;
	
	public BarFinderRepository (){
		barDao = new BarFinderInElasticSearchDao();
	}
	
	public Bar getBar (String id) throws UserNotFoundException{
		return barDao.getBarById(id);
	}
	
	public void addBar(Bar bar){
		barDao.addBar(bar);
	}
	
	public void deleteBar (String id){
		barDao.deleteBar(id);
	}

}
