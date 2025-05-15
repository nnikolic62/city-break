package com.city_break.city_break.controller;

import com.city_break.city_break.entity.City;
import com.city_break.city_break.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/city")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities(){
        List<City> cities = cityService.getAllCities();

        return ResponseEntity.ok(cities);
    }
}
