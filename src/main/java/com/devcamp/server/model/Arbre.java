package com.devcamp.server.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 2/18/12
 * Time: 2:00 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@XmlRootElement
public class Arbre {
	
	@Id
    private ObjectId id;
	
    private String HAUTEUR;
    private String recordid;
    private String ADRESSE;
    private String ESPECE;
    private String ARRONDISSE;
    private String FAMILLE;
    private String[] geom_x_y;
    private String geom_name;
    private String GENRE;
    private String NOM_COMMUN;
    private String CIRCONF;
    private String ANNEE__PLA;
    private String ESPACE_V_1;
    private String datasetid;
    
	public Arbre() {

    }

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getHAUTEUR() {
		return HAUTEUR;
	}

	public void setHAUTEUR(String hAUTEUR) {
		HAUTEUR = hAUTEUR;
	}

	public String getRecordid() {
		return recordid;
	}

	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}

	public String getADRESSE() {
		return ADRESSE;
	}

	public void setADRESSE(String aDRESSE) {
		ADRESSE = aDRESSE;
	}

	public String getESPECE() {
		return ESPECE;
	}

	public void setESPECE(String eSPECE) {
		ESPECE = eSPECE;
	}

	public String getARRONDISSE() {
		return ARRONDISSE;
	}

	public void setARRONDISSE(String aRRONDISSE) {
		ARRONDISSE = aRRONDISSE;
	}

	public String getFAMILLE() {
		return FAMILLE;
	}

	public void setFAMILLE(String fAMILLE) {
		FAMILLE = fAMILLE;
	}

	public String[] getGeom_x_y() {
		return geom_x_y;
	}

	public void setGeom_x_y(String[] geom_x_y) {
		this.geom_x_y = geom_x_y;
	}

	public String getGeom_name() {
		return geom_name;
	}

	public void setGeom_name(String geom_name) {
		this.geom_name = geom_name;
	}

	public String getGENRE() {
		return GENRE;
	}

	public void setGENRE(String gENRE) {
		GENRE = gENRE;
	}

	public String getNOM_COMMUN() {
		return NOM_COMMUN;
	}

	public void setNOM_COMMUN(String nOM_COMMUN) {
		NOM_COMMUN = nOM_COMMUN;
	}

	public String getCIRCONF() {
		return CIRCONF;
	}

	public void setCIRCONF(String cIRCONF) {
		CIRCONF = cIRCONF;
	}

	public String getANNEE__PLA() {
		return ANNEE__PLA;
	}

	public void setANNEE__PLA(String aNNEE__PLA) {
		ANNEE__PLA = aNNEE__PLA;
	}

	public String getESPACE_V_1() {
		return ESPACE_V_1;
	}

	public void setESPACE_V_1(String eSPACE_V_1) {
		ESPACE_V_1 = eSPACE_V_1;
	}

	public String getDatasetid() {
		return datasetid;
	}

	public void setDatasetid(String datasetid) {
		this.datasetid = datasetid;
	}

	@Override
	public String toString() {
		return "Arbre [HAUTEUR=" + HAUTEUR + ", recordid=" + recordid
				+ ", ADRESSE=" + ADRESSE + ", ESPECE=" + ESPECE
				+ ", ARRONDISSE=" + ARRONDISSE + ", FAMILLE=" + FAMILLE
				+ ", geom_x_y=" + Arrays.toString(geom_x_y) + ", geom_name="
				+ geom_name + ", GENRE=" + GENRE + ", NOM_COMMUN=" + NOM_COMMUN
				+ ", CIRCONF=" + CIRCONF + ", ANNEE__PLA=" + ANNEE__PLA
				+ ", ESPACE_V_1=" + ESPACE_V_1 + ", datasetid=" + datasetid
				+ "]";
	}
    
    
     
     

        

  
}
