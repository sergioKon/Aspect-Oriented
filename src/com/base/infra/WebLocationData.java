package com.base.infra;

import java.net.URL;
import java.util.TimeZone;

public class WebLocationData {
	private String ip;
	private String city;
	private String region;
	private String counntry;
	private double location;
	private TimeZone timeZone;
	private URL readme;

	public WebLocationData() {
	}

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

	public String getCounntry() {
		return counntry;
	}

	public void setCounntry(String counntry) {
		this.counntry = counntry;
	}

	public double getLocation() {
		return location;
	}

	public void setLocation(double location) {
		this.location = location;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	public URL getReadme() {
		return readme;
	}

	public void setReadme(URL readme) {
		this.readme = readme;
	}
}