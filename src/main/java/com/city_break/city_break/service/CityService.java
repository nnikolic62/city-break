package com.city_break.city_break.service;

import com.city_break.city_break.entity.City;

import java.util.List;

public interface CityService {

    List<City> getAllCities();

    City getCity(Long id);

    City addCity(City city);

    City editCity(City city);

    void deleteCity(Long id);
}
