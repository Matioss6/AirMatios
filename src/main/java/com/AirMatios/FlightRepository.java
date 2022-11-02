package com.AirMatios;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends ReactiveCrudRepository<Flight, Integer> {
}
