package com.city_break.city_break.controller;

import com.city_break.city_break.entity.City;
import com.city_break.city_break.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cities")
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

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable Long id){
        City city = cityService.getCity(id);

        return ResponseEntity.ok(city);
    }

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city){
        City savedCity = cityService.addCity(city);

        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<City> editCity(@RequestBody City city){
        City editedCity = cityService.editCity(city);

        return ResponseEntity.ok(editedCity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Long id){
        cityService.deleteCity(id);

        return ResponseEntity.ok("Successfully deleted");
    }
}
