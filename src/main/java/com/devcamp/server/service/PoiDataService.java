package com.devcamp.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import com.devcamp.server.model.PoiData;
import com.devcamp.server.resources.ResponseData;
import com.devcamp.server.util.InitDatabase;


public class PoiDataService {
	
	private List<PoiData> listData = InitDatabase.storeDocument();
	
	public PoiDataService(){
	   	
	}
	
	public List<ResponseData> findData(PoiData poiData, double radius){
	  
		//extract all stuff in the range from MongoDB
	    List<ResponseData> responses = new ArrayList<ResponseData>();
	    for (PoiData poi : listData){
	    	if (gpsDistance(poiData, poi) <= radius){
	    		responses.add(new ResponseData(poi));
	    	}
	    }
	    return responses;
		
	}
	
	public double gpsDistance(PoiData source, PoiData dest){
		//d = R * (Pi/2 - ArcSin( sin(destLat) * sin(sourceLat) 
		//+ cos(destLong - sourceLong) * cos(destLat) * cos(sourceLat)))
		
		double destLat = dest.getLatitude();
		double destLong = dest.getLongitute();
		double sourceLat = source.getLatitude();
		double sourceLong = source.getLongitute();
		
		double d = 6378 * (Math.PI/2 - Math.asin( Math.sin(destLat) * Math.sin(sourceLat) 
				+ Math.cos(destLong - sourceLong) * Math.cos(destLat) * Math.cos(sourceLat)));
		
		return d;
	}
	
	public static void main(String[] args){
		PoiDataService pds = new PoiDataService();
//		//PoiData pdt = pds.gpsDistanc
//		for (ResponseData rps: pds.findData(poiData, 100));
//		
	}

	
}
