package com.countryservice.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.countryservice.beans.Country;
import com.countryservice.controllers.AddResponse;

@Component
public class CountryService {

	static HashMap<Integer, Country> countryIdMap;

	public CountryService() {
		countryIdMap = new HashMap<Integer, Country>();

		Country indiaCountry = new Country(1, "India", "New Delhi");
		Country usaCountry = new Country(2, "USA", "Washington");
		Country ukCountry = new Country(3, "UK", "London");

		countryIdMap.put(1, indiaCountry);
		countryIdMap.put(2, usaCountry);
		countryIdMap.put(3, ukCountry);

	}

	// Utility to get maximum Id
	public static int getMaxId() {
		int maxId = 0;
		for (int id : countryIdMap.keySet()) {
			if (maxId <= id) {
				maxId = id;
			}
		}
		return maxId + 1;
	}

	public List getAllCountries() {

		List countries = new ArrayList(countryIdMap.values());
		return countries;
	}

	public Country getCountryById(int id) {

		Country country = countryIdMap.get(id);
		return country;
	}

	public Country getCountryByName(String countryName) {

		Country country = null;

		for (int i : countryIdMap.keySet()) {
			if (countryIdMap.get(i).getCountryName().equals(countryName))
				country = countryIdMap.get(i);
		}

		return country;
	}

	public Country addCountry(Country country) {

		country.setId(getMaxId());
		countryIdMap.put(country.getId(), country);

		return country;
	}

	public Country updateCountry(Country country) {

		if (country.getId() > 0) {
			countryIdMap.put(country.getId(), country);
		}

		return country;
	}

	public AddResponse deleteCountry(int id) {

		countryIdMap.remove(id);

		AddResponse response = new AddResponse();
		response.setMessage("Country Deleted !");
		response.setId(id);
		return response;
	}
}
