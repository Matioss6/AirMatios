package com.AirMatios.Repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlightRepository extends PagingAndSortingRepository<Flight, Integer> {

    /* Not needed here as well
    @Query("SELECT * FROM Flight WHERE departure_City = :departureCity")
    public Iterable<Flight> showFlightByDeparture(String departureCity);

    @Query("SELECT * FROM Flight WHERE price <= :price")
    public Iterable<Flight> showFlightByPrice(Double price);

    @Query("SELECT * FROM Flight WHERE price <= :price AND departure_City = :departureCity AND destination_City = :destinationCity")
    public Iterable<Flight>  showFlightByPriceAndDirection(Double price, String departureCity, String destinationCity);

    @Query("SELECT * FROM Flight WHERE price <= :price AND departure_City = :departureCity")
    public Iterable<Flight>  showFlightByPriceAndDirection(Double price, String departureCity);

    */

    @Query("SELECT * FROM Flight WHERE (:price IS NULL OR price <= :price) AND (:departureCity IS NULL OR LOWER(departure_City) LIKE LOWER(:departureCity)) AND (:destinationCity IS NULL OR LOWER(destination_City) LIKE LOWER(:destinationCity))")
    Iterable<Flight>  showFlight(Double price, String departureCity, String destinationCity);

}
