package com.devcamp.server.model;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.utils.IndexDirection;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PoiData implements Serializable{

    @Id
	 ObjectId id;
	private String titre;
	private String addresse;
	private String description;
	private double longitude;
	private double latitude;
	private String category;



    @Indexed(IndexDirection.GEO2D)
    private double[] loc;

    private int sumsOnePlusOnes;

    private List<PlusOne> plusOneList;

	
	public PoiData(){
        plusOneList = new ArrayList<PlusOne>();

		
	}


    public int getSumsOnePlusOnes() {
        return this.plusOneList.size();
    }

    public void setSumsOnePlusOnes(int sumsOnePlusOnes) {
        this.sumsOnePlusOnes = sumsOnePlusOnes;
    }

    public List<PlusOne> getPlusOneList() {
        return plusOneList;
    }

    public void setPlusOneList(List<PlusOne> plusOneList) {
        this.plusOneList = plusOneList;
    }

    public double[] getLoc() {
        return loc;
    }

    public void setLoc(double[] loc) {
        this.loc = loc;
    }

    public void setLoc(){
        loc= new double[]{this.latitude, this.longitude};
    }

    public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

    @Override
    public String toString() {
        return "PoiData{" +
                "titre='" + titre + '\'' +
                ", addresse='" + addresse + '\'' +
                ", description='" + description + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", category='" + category + '\'' +
                '}';
    }
}
