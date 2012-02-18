package com.devcamp.server.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;

import com.devcamp.server.model.PoiData;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.gson.Gson;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

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
	public static void storeDocument(){
	
		URL url = InitDatabase.class.getResource("/MH-Ile-de-France.txt-fr_utf8_monument_opendata.paris.csv");
		File csvFile = new File(url.getFile());
		 
		BufferedReader buffer;
		try {
			 buffer = new BufferedReader(new FileReader(csvFile));
			 String line;
			 
			 while ((line =buffer.readLine())!=null) {
				 //System.out.println(line);
				 String[] splitted = line.split("\\;");
				 
//				 for(String s: splitted){
//					 PoiData poiData = new PoiData();
//					 poiData.setTitre(splitted[0]);
//					 poiData.setDescription(splitted[1]);
//					 poiData.setAddresse(splitted[2]);
//					 poiData.setLatitude(Double.valueOf((splitted[3])));
//					 poiData.setLongitute((Double.valueOf((splitted[4]))));
//					 poiData.setTitre(splitted[5]);
//					 
//					 System.out.println(poiData);
//				 }
				 System.out.println();
				 
				 
			 }
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
			
		}
		
		
		
	}
		
	
	public static void main(String[] args){
		//init();
		storeDocument();
//		String tt = "Eglise du Vieux-Saint-Ouen;L'église : inscription par arrêté du 6 juin 1933. . Moyen Age;Eglise du Vieux-Saint-Ouen  Saint-Ouen;48.7035638;-0.1805359;monument";
//		String[] splitted =tt.split("\\;");
//		for (String s  : splitted){
//			System.out.println(s);
//		}
	}

}
