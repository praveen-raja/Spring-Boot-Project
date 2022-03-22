package com.countryservice.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryservice.app.beans.Country;
import com.countryservice.app.services.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;

	@GetMapping("/getcountries")
	public List<Country> getAllCountries() {

		return countryService.getAllCountries();
	}

	@GetMapping("/getcountries/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") int id) {

		try {
			Country country = countryService.getCountryById(id);
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		}

		catch (Exception e) {
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getcountries/countryname")
	public ResponseEntity<Country> getCountryByName(@RequestParam(value = "name") String countryName) {
		try {
			Country country = countryService.getCountryByName(countryName);
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		}

		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country) {

		return countryService.addCountry(country);
	}

	@PutMapping("/updatecountry/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable(value = "id") int id, @RequestBody Country country) {

		try {
			Country existCountry = countryService.getCountryById(id);

			existCountry.setCountryName(country.getCountryName());
			existCountry.setCountryCapital(country.getCountryCapital());

			Country updatedCountry = countryService.updateCountry(existCountry);

			return new ResponseEntity<Country>(updatedCountry, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	@DeleteMapping("/deletecountry/{id}")
	public ResponseEntity<AddResponse> deleteCountry(@PathVariable(value = "id") int id) {

		Country country = null;
		AddResponse response = new AddResponse();
		try {
			country = countryService.getCountryById(id);
			response = countryService.deleteCountry(country);

			return new ResponseEntity<AddResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

}
