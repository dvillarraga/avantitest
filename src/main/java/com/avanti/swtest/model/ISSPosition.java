package com.avanti.swtest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Yesid
 * This class represents the ISS position in the business layer
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ISSPosition {
	
	private String name = null;
	private int id = 0;
	private double longitude = Double.NaN;
	private double latitude = Double.NaN;
	
	public ISSPosition() {}
	
	public ISSPosition(double longitude, double latitude, String name, int id) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
		this.id = id;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
