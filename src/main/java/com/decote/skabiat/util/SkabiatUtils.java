package com.decote.skabiat.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.decote.skabiat.model.Bar;

public class SkabiatUtils {
	
	public static Bar getBarFromMap (Map <String, Object> map){
		Bar barToReturn = new Bar();
		barToReturn.setId((String)map.get("id"));
		barToReturn.setName((String)map.get("name"));
		barToReturn.setDescription((String)map.get("description"));
		ArrayList<String> location = (ArrayList<String>)map.get("location");
		barToReturn.setLongitude(location.get(0));
		barToReturn.setLatitude(location.get(1));
		return barToReturn;
	}
	
	
	public static Map<String, Object> getMapFromBar (Bar bar){
		Map <String, Object> map = new HashMap <String, Object>();
		map.put("name", bar.getName());
		map.put("description", bar.getDescription());
		String [] location = {bar.getLongitude().toString(), bar.getLatitude().toString()};
		map.put("location", location);
		return map;
	}
	
	
	

}
