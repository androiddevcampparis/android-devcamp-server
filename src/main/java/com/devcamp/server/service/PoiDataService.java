package com.devcamp.server.service;

import com.devcamp.server.model.PoiData;
import com.devcamp.server.resources.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PoiDataService {

    @Autowired
    private MongoService mongoService;
	

	public PoiDataService(){
	   	
	}
	
	public List<ResponseData> findData(PoiData poiData, double radius, String category){
	  
		//extract all stuff in the range from MongoDB
	    List<ResponseData> responses = new ArrayList<ResponseData>();
	    for (PoiData poi : mongoService.getPoisFromFiles()){
	    	if ((gpsDistance(poiData, poi) <= radius) && (poi.getCategory().equals(category))){
	    		responses.add(new ResponseData(poi));
	    	}
	    }
	    return responses;
		
	}
	
	public double gpsDistance(PoiData source, PoiData dest){
		//d = R * (Pi/2 - ArcSin( sin(destLat) * sin(sourceLat) 
		//+ cos(destLong - sourceLong) * cos(destLat) * cos(sourceLat)))
		
		double destLat = dest.getLatitude();
		double destLong = dest.getLongitude();
		double sourceLat = source.getLatitude();
		double sourceLong = source.getLongitude();
		
		double d = 6378 * (Math.PI/2 - Math.asin( Math.sin(destLat) * Math.sin(sourceLat) 
				+ Math.cos(destLong - sourceLong) * Math.cos(destLat) * Math.cos(sourceLat)));
		
		return d;
	}

}
