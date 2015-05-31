package com.decote.skabiat.repo;

import com.decote.skabiat.dao.BarFinderInMemoryDao;
import com.decote.skabiat.dao.IBarFinderDao;
import com.decote.skabiat.model.Bar;

public class BarFinderRepository {
	
	private IBarFinderDao barDao;
	
	public BarFinderRepository (){
		barDao = new BarFinderInMemoryDao();
	}
	
	public Bar getBar (String id){
		return barDao.getBar(id);
	}
	
	public void addBar(Bar bar){
		barDao.addBar(bar);
	}

}
