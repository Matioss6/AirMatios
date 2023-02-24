package com.AirMatios.Service;

import com.AirMatios.Repository.Flight;
import com.AirMatios.Repository.FlightRepository;
import com.AirMatios.Repository.UserData;
import com.AirMatios.Repository.UserDataRepository;
import org.springframework.stereotype.Service;

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

    /* Not needed anymore here also
    public Iterable<Flight> showAllFlights(){
        return flightRepository.findAll();
    }

    public Iterable<Flight> showFlightByDeparture(String departureCity){
        return flightRepository.showFlightByDeparture(departureCity);
    }

    public Iterable<Flight> showFlightByPrice(Double price){
        return flightRepository.showFlightByPrice(price);
    }

    public Iterable<Flight> showFlightByPriceAndDirection(Optional<Double> price, Optional<String> departureCity, Optional<String> destinationCity){

        return flightRepository.showFlightByPriceAndDirection(price.get(), departureCity.get(), destinationCity.get());
    }

         */

    public Iterable<Flight> showFlight(Double price, String departureCity, String destinationCity){

        return flightRepository.showFlight(price, departureCity, destinationCity);
    }

}
