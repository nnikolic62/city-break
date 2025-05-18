package com.city_break.city_break.service.impl;

import com.city_break.city_break.entity.City;
import com.city_break.city_break.repository.CityRepository;
import com.city_break.city_break.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCity(Long id) {
        City foundCity = cityRepository.findById(id).orElseThrow(() -> new RuntimeException());

        return foundCity;
    }

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City editCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(Long id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new RuntimeException());

        cityRepository.delete(city);
    }
}
