package de.aptsolutions.scraper.model;

import java.util.List;

public class Offer {

	private String headline;
	private String datePosted;
	private String location;
	private String firma;
	private String vertragsart;
	private String startDate;
	private String dauer;
	private List<String> categories; 
	private String content;
	

	public Offer(){
		
	}
	
	
	public String getHeadline() {
		return headline;
	}



	public void setHeadline(String headline) {
		this.headline = headline;
	}



	public String getDatePosted() {
		return datePosted;
	}



	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getFirma() {
		return firma;
	}



	public void setFirma(String firma) {
		this.firma = firma;
	}



	public String getVertragsart() {
		return vertragsart;
	}



	public void setVertragsart(String vertragsart) {
		this.vertragsart = vertragsart;
	}



	public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getDauer() {
		return dauer;
	}



	public void setDauer(String dauer) {
		this.dauer = dauer;
	}



	public List<String> getCategories() {
		return categories;
	}



	public void setCategories(List<String> categories) {
		this.categories = categories;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Offer(String headline, String datePosted, String location, String firma, String vertragsart,
			String startDate, String dauer, List<String> categories, String content) {
		super();
		this.headline = headline;
		this.datePosted = datePosted;
		this.location = location;
		this.firma = firma;
		this.vertragsart = vertragsart;
		this.startDate = startDate;
		this.dauer = dauer;
		this.categories = categories;
		this.content = content;
	}




	@Override
	public String toString() {
		
		StringBuilder categoriesList= new StringBuilder();
		
		for (String s : categories){
			
			categoriesList.append(s + ", ");
		}
		
		
		return "Offer [headline=" + headline + "| datePosted=" + datePosted + "| location=" + location + "| Firma="
				+ firma + "| vertragsart=" + vertragsart + "| startDate=" + startDate + "| dauer=" + dauer
				+ "| categories=" + categoriesList.toString() + "| content=" + content + "]";
	}
	
	
	
}
