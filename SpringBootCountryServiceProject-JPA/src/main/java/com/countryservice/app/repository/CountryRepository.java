package com.countryservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.countryservice.app.beans.Country;


public interface CountryRepository extends JpaRepository<Country, Integer>{

}
