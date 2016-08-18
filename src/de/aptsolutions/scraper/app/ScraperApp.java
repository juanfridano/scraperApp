package de.aptsolutions.scraper.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.aptsolutions.scraper.cookies.CookieMaker;
import de.aptsolutions.scraper.model.Offer;
import de.aptsolutions.scraper.model.OfferScraper;

public class ScraperApp {

	public static void main(String[] args) throws IOException {

		if (args == null || args.length != 2) {

			System.err.println("Pass Username and Password for http://www.freelancermap.de");
			
		} else {
			// FreelancerMap ID
			String id = args[0];
			// FreelancerMap Password
			String password = args[1];
			// Ideally an Array of links should be passed as Argument
			//for the sake of testing, array is provided 
			String[] link = {
					"http://www.freelancermap.de/nproj/1187798.html?utm_source=Projektagent&utm_medium=E-Mail&utm_campaign=link",
					"http://www.freelancermap.de/nproj/1187796.html?utm_source=Projektagent&utm_medium=E-Mail&utm_campaign=link",
					"http://www.freelancermap.de/nproj/1187788.html?utm_source=Projektagent&utm_medium=E-Mail&utm_campaign=link",
					"http://www.freelancermap.de/nproj/1187594.html?utm_source=Projektagent&utm_medium=E-Mail&utm_campaign=link" };
			List<Offer> offersList = new ArrayList<Offer>();

			// get the Cookies
			CookieMaker cooks = new CookieMaker();
			Map<String, String> cookies = cooks.getCookie(id, password);

			// send the links one by one to be scraped by OfferScraper.class
			for (int i = 0; i < link.length; i++) {

				Offer scrap = new OfferScraper().Scraper(link[i], cookies);

				// Add the objects to a List
				offersList.add(scrap);
			}

			for (Offer o : offersList) {

				// TODO pass into HTML using getters instead of printing to
				// console
				System.out.println(o.toString());
				System.out.println("\n-------------------------------------------------\n");

				// Uncomment and comment out previous Lines
				// System.out.println(o.getHeadline());
			}

		}
	}
}