package com.AirMatios.Controllers;

import com.AirMatios.Repository.Flight;
import com.AirMatios.Repository.Orders;
import com.AirMatios.Service.BookingService;
import com.AirMatios.Service.LoginService;
import com.AirMatios.Service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AirMatiosControllerSearching {

    private final BookingService bookingService;
    private final LoginService loginService;
    private final SearchService searchService;


    public AirMatiosControllerSearching(BookingService bookingService, LoginService loginService, SearchService searchService) {
        this.bookingService = bookingService;
        this.loginService = loginService;
        this.searchService = searchService;
    }



    @PostMapping("search")
    public Iterable<Flight> showFlight(@RequestParam(required = false) Double price,@RequestParam(required = false) String departureCity,@RequestParam(required = false) String destinationCity){
        return searchService.showFlight(price, departureCity, destinationCity);
    }


    @GetMapping("showorders")
    public Iterable<Orders> findOrdersByUser(){
        if(!(loginService.getLoggedUser() == null))
            return bookingService.findOrdersByUser(loginService.getLoggedUser());
        else
            System.out.println("proszę się zalogować");
        return null;
    }




}
