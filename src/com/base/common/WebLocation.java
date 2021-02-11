package com.base.common;

import java.net.URL;
import java.util.Locale;
import com.google.gson.annotations.SerializedName;

public class WebLocation {
  private String ip;
  private String city;
  private String region;
  @SerializedName(value = "country")
  private String countryCode;;
  private String countryName;
  @SerializedName(value = "loc", alternate = "location")
  private String  location;
  private String org;
  private String timeZone;
  private URL readme;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
		Locale locale = new Locale("", countryCode);
		this.countryName= locale.getDisplayCountry();
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public URL getReadme() {
		return readme;
	}
	public void setReadme(URL readme) {
		this.readme = readme;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	} 
}
