package com.city_break.city_break.repository;

import com.city_break.city_break.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
