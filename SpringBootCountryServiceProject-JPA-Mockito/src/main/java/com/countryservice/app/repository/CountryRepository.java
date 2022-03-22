package com.countryservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.countryservice.app.beans.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
