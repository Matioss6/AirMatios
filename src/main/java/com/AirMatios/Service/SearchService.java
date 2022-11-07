package com.AirMatios.Service;

import com.AirMatios.Repository.Flight;
import com.AirMatios.Repository.FlightRepository;
import com.AirMatios.Repository.UserData;
import com.AirMatios.Repository.UserDataRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class SearchService {

    private UserDataRepository userDataRepository;
    private FlightRepository flightRepository;

    public SearchService(UserDataRepository userDataRepository, FlightRepository flightRepository) {
        this.userDataRepository = userDataRepository;
        this.flightRepository = flightRepository;
    }



    public Iterable<UserData> showAllUsers(){
        return userDataRepository.findAll();
    }

    public Optional<UserData> findDataAboutUser(String login){
        return userDataRepository.findById(login);
    }

    public Iterable<Flight> showAllFlights(){
        return flightRepository.findAll();
    }

    public Iterable<Flight> showFlightByDeparture(String departureCity){
        return flightRepository.showFlightByDeparture(departureCity);
    }

    public Iterable<Flight> showFlightByPrice(Double price){
        return flightRepository.showFlightByPrice(price);
    }

    public Iterable<Flight> showFlightByPriceAndDirection(Double price, String departureCity, String destinationCity){
        return flightRepository.showFlightByPriceAndDirection(price, departureCity, destinationCity);
    }

}
