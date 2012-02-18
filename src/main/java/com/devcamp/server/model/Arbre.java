package com.devcamp.server.model;

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
	
    private String hauteur;
    private String recordid;
    private String addresse;
    private String espece;
    private String arrondisse;
    private String famille;
    private String[] geom_x_y;
    private String geom_name;
    private String genre;
    private String nom_commun;
    private String circonf;
    private String annee__pla;
    private String espace_v_1;
    private String datasetid;

    public String getHauteur() {
        return hauteur;
    }

    public void setHauteur(String hauteur) {
        this.hauteur = hauteur;
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getArrondisse() {
        return arrondisse;
    }

    public void setArrondisse(String arrondisse) {
        this.arrondisse = arrondisse;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNom_commun() {
        return nom_commun;
    }

    public void setNom_commun(String nom_commun) {
        this.nom_commun = nom_commun;
    }

    public String getCirconf() {
        return circonf;
    }

    public void setCirconf(String circonf) {
        this.circonf = circonf;
    }

    public String getAnnee__pla() {
        return annee__pla;
    }

    public void setAnnee__pla(String annee__pla) {
        this.annee__pla = annee__pla;
    }

    public String getEspace_v_1() {
        return espace_v_1;
    }

    public void setEspace_v_1(String espace_v_1) {
        this.espace_v_1 = espace_v_1;
    }

    public String getDatasetid() {
        return datasetid;
    }

    public void setDatasetid(String datasetid) {
        this.datasetid = datasetid;
    }



    public Arbre(){

    }


}
