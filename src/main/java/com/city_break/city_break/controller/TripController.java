package com.city_break.city_break.controller;

import com.city_break.city_break.entity.Trip;
import com.city_break.city_break.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/trips")
public class TripController {

    private TripService tripService;

    @Autowired
    public TripController(TripService tripService){
        this.tripService = tripService;
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAllTrips(){
        List<Trip> trips = tripService.getAllTrips();

        return ResponseEntity.ok(trips);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTrip(@PathVariable Long id){
        Trip trip = tripService.getTrip(id);

        return ResponseEntity.ok(trip);
    }

    @PostMapping
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip){
        Trip savedTrip = tripService.addTrip(trip);

        return new ResponseEntity<>(savedTrip, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Trip> editTrip(@RequestBody Trip trip){
        Trip savedTrip = tripService.editTrip(trip);

        return ResponseEntity.ok(savedTrip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable Long id){
        tripService.deleteTrip(id);

        return ResponseEntity.ok("Successfully deleted");
    }
}
