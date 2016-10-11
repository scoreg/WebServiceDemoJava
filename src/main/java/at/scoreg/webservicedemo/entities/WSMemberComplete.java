package at.scoreg.webservicedemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WSMemberComplete {
	
	private String scoutId;
	private String prefixTitle;
	private String postfixTitle;
	private String firstname;
	private String secondname;
	private String lastname;
	
	public String getScoutId() {
		return scoutId;
	}
	public String getPrefixTitle() {
		return prefixTitle;
	}
	public String getPostfixTitle() {
		return postfixTitle;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public String getLastname() {
		return lastname;
	}
	
}
