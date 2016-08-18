package de.aptsolutions.scraper.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OfferScraper {

	
	List<String> categoriesList = new ArrayList<String>();

	//There is also a Constructor-using-Fields for the Offer Bean, 
	//in this case using setters
	public Offer Scraper(String link, Map<String, String> cookies) {
		Offer offer = new Offer();

		try {
			//Log into Projects' links using the Map of Cookies
			Document doc = Jsoup.connect(link).cookies(cookies).get();

			// set headline
			offer.setHeadline(doc.getElementsByAttributeValue("itemprop", "title").html());

			// set headline Data
			Elements headlineNext = doc.getElementsByClass("project-detail-description");
			offer.setVertragsart(headlineNext.get(0).html());
			offer.setStartDate(headlineNext.get(1).html());
			offer.setDauer(headlineNext.get(2).html());

			// set datePosted
			offer.setDatePosted(doc.getElementsByAttributeValue("itemprop", "datePosted").html());
			;

			// set location
			offer.setLocation(doc.getElementsByAttributeValue("itemprop", "addressLocality").html());
			;

			// set Firma
			Elements hiringOrganization = doc.getElementsByAttributeValue("itemprop", "hiringOrganization");
			Element firma = hiringOrganization.first();
			offer.setFirma(firma.child(0).children().html());

			// set Categories
			Elements categoriesElements = doc.getElementsByClass("profil_categories_listing");

			for (Element e : categoriesElements) {

				categoriesList.add(e.html());
			}

			offer.setCategories(categoriesList);

			// get content
			offer.setContent(doc.getElementsByClass("projectcontent").html());

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return offer;

	}

}
