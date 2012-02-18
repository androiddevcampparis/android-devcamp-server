package com.devcamp.server.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import com.devcamp.server.model.PoiData;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;

import com.mongodb.Mongo;


public class InitDatabase {

	public static Mongo mongo;
	public  static Datastore ds ;
	public static Morphia morphia;
	private static final String DB_NAME="mongo-android";
	private static final String URL_DB="localhost";
	private static final int PORT =27017;


	public static void init(){
		try {
			mongo = new Mongo(URL_DB, PORT);
			morphia = new Morphia().map(PoiData.class); 
			ds = morphia        
					.createDatastore(mongo, DB_NAME);

		} catch (Exception e) {
			throw new RuntimeException("Error Initializing MongoDB .." + e);
		}

	}

	/**
	 * 
	 */
	public static List<PoiData> storeDocument(){
        
		List<PoiData> list = new ArrayList<PoiData>();
		URL url = InitDatabase.class.getResource("/MH-Ile-de-France.txt-fr_utf8_monument_opendata.paris.csv");
		File csvFile = new File(url.getFile());

		BufferedReader buffer;
		try {
			buffer = new BufferedReader(new FileReader(csvFile));
			String line;

			while ((line =buffer.readLine())!=null) {
				
				String[] splitted = line.split("\\t");
				PoiData poiData= new PoiData();
				 poiData.setTitre(splitted[0]);
				 poiData.setDescription(splitted[1]);
				 poiData.setAddresse(splitted[2]);
				 poiData.setLatitude(Double.valueOf(splitted[3]));
				 poiData.setLongitute(Double.valueOf(splitted[4]));
				 poiData.setCategory(splitted[5]);
				 list.add(poiData);
				
			}
			
		}

	catch (FileNotFoundException e) {
	
		e.printStackTrace();
	}catch (IOException e){
		e.printStackTrace();

	}
		
	return list;
}
	public static void main(String[] args){
		for (PoiData poidata :InitDatabase.storeDocument()){
			System.out.println(poidata);
		}
		
	}


}
