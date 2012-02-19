package com.devcamp.server.model;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import org.bson.types.ObjectId;


import java.io.Serializable;

//import com.google.code.morphia.annotations.Id;

@Entity
public class User implements Serializable {

    @Id
	private ObjectId id;
	private String uid;
	private String name;
	
	public User(){
		
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
