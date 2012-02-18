package com.devcamp.server.util;

import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;

import org.omg.CORBA.ARG_IN;

/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 2/18/12
 * Time: 4:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProcessArbres {
	final static String ARBRES_URL ="http://demo2.opendatasoft.com/api/fetch/dataset/arbresremarquablesparis2011/?format=json&pretty_print=true";

	public static String readJsonArray(String url){
		StringBuffer sb = new StringBuffer();
		BufferedReader	 buffer = null;
		String line;
		try {
			buffer = new BufferedReader(
				    	new InputStreamReader(
				    		new URL(url).openStream()));
			while(( line =buffer.readLine() )!= null){
                    sb.append(line+"\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}


//	public static void deserializeArbres(){
//		List<Arbre> arbres = new ArrayList<Arbre>();
//
//		Type listType =  new TypeToken<List<Arbre>>(){}.getType();
//		arbres = new Gson().fromJson(readJsonArray(ARBRES_URL), listType); 
//		return arbres;
//	}

	public static void main(String[] args){
		//System.out.println(readJsonArray("http://demo2.opendatasoft.com/api/fetch/dataset/arbresremarquablesparis2011/?format=json&pretty_print=true"));
//		for (Arbre arbre : deserializeArbres()){
//			System.out.println(arbre);
//			
//		}

	}



}
