package at.scoreg.webservicedemo.entities;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 *
 * @author DI (FH) DI Hubert Novak
 * @date 01.12.2012
 *
 */

@XmlRootElement(name="Member")
@RequestMapping(name="member")
public class WSMember {

	private String scoutId;
	private String prefixTitle;
	private String postfixTitle;
	private String firstname;
	private String secondname;
	private String lastname;
	private String emailPrimary;
	private String emailSecondary;
	private String phoneLine;
	private String phoneMobile;
	private String phoneFax;
	private String street;
	private String postcode;
	private String city;
	private String province;
	private String country;
	private String sex;
	private String section;
	private String jobList;
	private String username;
	private String password;
	private String scoutState;
	
	@JsonFormat(shape=Shape.STRING, pattern="yyyy-MM-dd", locale="de_AT", timezone = "CET")
	private Date birthdate;
	
	@JsonFormat(shape=Shape.STRING, pattern="yyyy-MM-dd", locale="de_AT", timezone = "CET")
	private Date dayOfDeath;
	
	@JsonFormat(shape=Shape.STRING, pattern="yyyy-MM-dd", locale="de_AT", timezone = "CET")
	private Date dayOfRetirement;
	
	private String dynamicField1;
	private String dynamicField2;
	private String dynamicField3;
	private String dynamicField4;
	private String dynamicField5;
	private String organizationName;

	public String getScoutId() {
		return scoutId;
	}
	public void setScoutId(String scoutId) {
		this.scoutId = scoutId;
	}
	public String getPrefixTitle() {
		return prefixTitle;
	}
	public void setPrefixTitle(String prefixTitle) {
		this.prefixTitle = prefixTitle;
	}
	public String getPostfixTitle() {
		return postfixTitle;
	}
	public void setPostfixTitle(String postfixTitle) {
		this.postfixTitle = postfixTitle;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailPrimary() {
		return emailPrimary;
	}
	public void setEmailPrimary(String emailPrimary) {
		this.emailPrimary = emailPrimary;
	}
	public String getEmailSecondary() {
		return emailSecondary;
	}
	public void setEmailSecondary(String emailSecondary) {
		this.emailSecondary = emailSecondary;
	}
	public String getPhoneLine() {
		return phoneLine;
	}
	public void setPhoneLine(String phoneLine) {
		this.phoneLine = phoneLine;
	}
	public String getPhoneMobile() {
		return phoneMobile;
	}
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	public String getPhoneFax() {
		return phoneFax;
	}
	public void setPhoneFax(String phoneFax) {
		this.phoneFax = phoneFax;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getScoutState() {
		return scoutState;
	}
	public void setScoutState(String scoutState) {
		this.scoutState = scoutState;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getJobList() {
		return jobList;
	}
	public void setJobList(String jobList) {
		this.jobList = jobList;
	}

	public String getDynamicField1() {
		return dynamicField1;
	}

	public void setDynamicField1(String dynamicField1) {
		this.dynamicField1 = dynamicField1;
	}

	public String getDynamicField2() {
		return dynamicField2;
	}

	public void setDynamicField2(String dynamicField2) {
		this.dynamicField2 = dynamicField2;
	}

	public String getDynamicField3() {
		return dynamicField3;
	}

	public void setDynamicField3(String dynamicField3) {
		this.dynamicField3 = dynamicField3;
	}

	public String getDynamicField4() {
		return dynamicField4;
	}

	public void setDynamicField4(String dynamicField4) {
		this.dynamicField4 = dynamicField4;
	}

	public String getDynamicField5() {
		return dynamicField5;
	}

	public void setDynamicField5(String dynamicField5) {
		this.dynamicField5 = dynamicField5;
	}

	public Date getDayOfDeath() {
		return dayOfDeath;
	}

	public void setDayOfDeath(Date dayOfDeath) {
		this.dayOfDeath = dayOfDeath;
	}

	public Date getDayOfRetirement() {
		return dayOfRetirement;
	}

	public void setDayOfRetirement(Date dayOfRetirement) {
		this.dayOfRetirement = dayOfRetirement;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
}