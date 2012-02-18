package com.devcamp.server.resources;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

import com.devcamp.server.model.PoiData;

@XmlRootElement
public class ResponseData {
	private ObjectId id;
	private String title;
	private String description;
	private String addresse;
	private String category;
	
	private String url_image;
	private String wiki_link;
	
	public ResponseData (){
		
	}
	
	public ResponseData(PoiData poiData){
		this.id=poiData.getId();
		this.title=poiData.getTitre();
		this.description=poiData.getDescription();
		this.addresse=poiData.getDescription();
		this.category=poiData.getCategory();
		
	}
	

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public String getWiki_link() {
		return wiki_link;
	}

	public void setWiki_link(String wiki_link) {
		this.wiki_link = wiki_link;
	}
	
	
	public String buildWikiUrl(){
		return "";
		
	}
	
	public String findImagesURls(){
		return "";
		
	}
	
	
	
	
	

}
