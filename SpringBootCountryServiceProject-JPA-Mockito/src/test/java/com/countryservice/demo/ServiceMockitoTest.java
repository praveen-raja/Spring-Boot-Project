package com.countryservice.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.countryservice.app.beans.Country;
import com.countryservice.app.controllers.AddResponse;
import com.countryservice.app.repository.CountryRepository;
import com.countryservice.app.services.CountryService;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = ServiceMockitoTest.class)
public class ServiceMockitoTest {

	@Mock
	CountryRepository countryRepository;

	@InjectMocks
	CountryService countryService;

	public List<Country> mycountries;

	@Test
	@Order(1)
	public void test_getAllCountries() {

		List<Country> mycountries = new ArrayList<Country>();
		mycountries.add(new Country(1, "India", "New Delhi"));
		mycountries.add(new Country(2, "Japan", "Tokyo"));

		when(countryRepository.findAll()).thenReturn(mycountries); // Mocking part

		assertEquals(2, countryService.getAllCountries().size());
	}

	@Test
	@Order(2)
	public void test_getCountryById() {

		List<Country> mycountries = new ArrayList<Country>();
		mycountries.add(new Country(1, "India", "New Delhi"));
		mycountries.add(new Country(2, "Japan", "Tokyo"));

		int countryId = 1;

		when(countryRepository.findAll()).thenReturn(mycountries); // Mocking part
		assertEquals(countryId, countryService.getCountryById(countryId).getId());

	}
	
	@Test
	@Order(3)
	public void test_getCountryByName() {
		
		List<Country> mycountries = new ArrayList<Country>();
		mycountries.add(new Country(1, "India", "New Delhi"));
		mycountries.add(new Country(2, "Japan", "Tokyo"));
		
		String countryName = "India";
		
		when(countryRepository.findAll()).thenReturn(mycountries); // Mocking part
		assertEquals(countryName, countryService.getCountryByName(countryName).getCountryName());
		
	}
	
	@Test
	@Order(4)
	public void test_addCountry() {
				
		Country country = new Country(3, "Germany", "Berlin");
		
		when(countryRepository.save(country)).thenReturn(country);
		assertEquals(country,countryService.addCountry(country));
		
	}
	
	@Test
	@Order(5)
	public void test_updateCountry() {
		
		Country country = new Country(4, "Germany", "Berlin");
		
		when(countryRepository.save(country)).thenReturn(country);
		assertEquals(country,countryService.updateCountry(country));
		
	}
	
//	@Test
//	@Order(6)
//	public void test_deleteCountry() {
//		
//		Country country = new Country(4, "Germany", "Berlin");
//		
//		countryService.deleteCountry(country);
//		verify(countryRepository, times(1)).delete(country);
////		AddResponse response = new AddResponse("ountry Deleted!", 4);
////		int id =4;
////		
////		when(countryRepository.deleteById(id)).thenReturn(response);
////		assertEquals(country.getId(),countryService.deleteCountry(country).getId());
////		assertEquals(response.getMessage(),countryService.deleteCountry(country).getMessage());
//		
//	}

}
