package com.countryservice.app.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity // It refers table entity
@Table(name = "Country") //table name should exactly match with the name parameter "Country".
public class Country {

	@Id // referring primary key
	@Column(name = "id") // referring column which should exactly match with the name parameter "id".
	private int id;
	
	@Column(name = "country_name") // referring column which should exactly match with the name parameter "country_name".
	private String countryName;
	
	@Column(name= "capital") //// referring column which should exactly match with the name parameter "capital_name".
	private String countryCapital;
	
	public Country() {
		
	}

	public Country(int id, String countryName, String countryCapital) {
		this.id = id;
		this.countryName = countryName;
		this.countryCapital = countryCapital;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCapital() {
		return countryCapital;
	}

	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
}
