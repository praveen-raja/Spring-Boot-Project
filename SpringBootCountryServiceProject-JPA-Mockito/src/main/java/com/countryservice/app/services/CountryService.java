package com.countryservice.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.countryservice.app.beans.Country;
import com.countryservice.app.controllers.AddResponse;
import com.countryservice.app.repository.CountryRepository;

@Service
@Component
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	// Utility to get maximum Id
	public int getMaxId() {
		return countryRepository.findAll().size() + 1;
	}

	public List<Country> getAllCountries() {
		List<Country> countries = countryRepository.findAll();
		return countries;
	}

	public Country getCountryById(int id) {

		List<Country> countries = countryRepository.findAll();
		Country country = null;
		for (Country con : countries) {
			if (con.getId() == id) {
				country = con;
			}
		}
		return country;
	}

	public Country getCountryByName(String countryName) {
		List<Country> countries = countryRepository.findAll();
		Country country = null;
		for (Country name : countries) {
			if (name.getCountryName().equalsIgnoreCase(countryName)) {
				country = name;
			}
		}
		return country;
	}

	public Country addCountry(Country country) {
		country.setId(getMaxId());
		countryRepository.save(country);

		return country;
	}

	public Country updateCountry(Country country) {
		countryRepository.save(country);
		return country;
	}

	public AddResponse deleteCountry(Country country) {
		countryRepository.deleteById(country.getId());
		AddResponse response = new AddResponse();
		response.setMessage("Country Deleted!");
		response.setId(country.getId());
		return response;
	}

//	public void deleteCountry(Country country) {
//
//		countryRepository.delete(country);
//	}
}
