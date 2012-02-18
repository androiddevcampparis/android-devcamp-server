package com.devcamp.server.util;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.DBObject;


public class MapperMorphia {
	private Morphia morphia;
	public  static Datastore dataStore ;
	
	public MapperMorphia() {
		InitDatabase.init();
		this.morphia = InitDatabase.morphia;
		dataStore= InitDatabase.ds;
	}

	public <T extends Object> T fromDBObject(Class<T> entityClass,
			DBObject dbObject) {
		return this.morphia.fromDBObject(entityClass, dbObject);
	}

	public <T extends Object> DBObject toDBObject(T modelObject) {
		DBObject dbObject = this.morphia.toDBObject(modelObject);
		dbObject.removeField("className");
		return dbObject;
	}
	
	
}
