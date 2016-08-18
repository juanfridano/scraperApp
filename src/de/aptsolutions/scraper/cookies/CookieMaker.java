package de.aptsolutions.scraper.cookies;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;

public class CookieMaker {

		
	public Map<String,String> getCookie(String id, String password) throws IOException {

		//Log into main login Site 
		Connection.Response res = Jsoup.connect("https://www.freelancermap.de/index.php?module=user&func=login")
				.data("login", id , "password", password).method(Method.POST).execute();

		//Save Map of Cookies
		Map<String,String> sessionId = res.cookies();

		return sessionId;
	}
	
	
}
