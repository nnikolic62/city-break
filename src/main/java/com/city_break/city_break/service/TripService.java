package com.city_break.city_break.service;

import com.city_break.city_break.entity.City;
import com.city_break.city_break.entity.Trip;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TripService {

    List<Trip> getAllTrips();
    Trip getTrip(Long id);
    Trip addTrip(Trip trip);
    Trip editTrip(Trip trip);
    void deleteTrip(Long id);
}
