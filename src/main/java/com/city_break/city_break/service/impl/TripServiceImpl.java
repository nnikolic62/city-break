package com.city_break.city_break.service.impl;

import com.city_break.city_break.entity.Trip;
import com.city_break.city_break.repository.TripRepository;
import com.city_break.city_break.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository){
        this.tripRepository = tripRepository;
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Trip getTrip(Long id) {
        Trip foundTrip = tripRepository.findById(id).orElseThrow(() -> new RuntimeException());

        return foundTrip;
    }

    @Override
    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Trip editTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public void deleteTrip(Long id) {
        Trip foundTrip = tripRepository.findById(id).orElseThrow(() -> new RuntimeException());

        tripRepository.delete(foundTrip);
    }
}
