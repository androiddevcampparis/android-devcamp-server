package com.devcamp.server.util;

import java.util.ArrayList;
import java.util.List;

import com.devcamp.server.model.Arbre;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 2/18/12
 * Time: 4:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProcessArbres {
    final String ARBRES_URL ="http://demo2.opendatasoft.com/api/fetch/dataset/arbresremarquablesparis2011/?format=json&pretty_print=true";

    public List<Arbre> deserializeArbres(){
    	List<Arbre> arbres = new ArrayList<Arbre>();
    	Gson gson = new Gson();
    	Type listType =  new TypeToken<List<Arbre>>(){}.getType();
    	
    	
    	
    	return arbres;
    }




}
