package com.AirMatios;

import com.AirMatios.Repository.Flight;
import com.AirMatios.Repository.Orders;
import com.AirMatios.Repository.UserData;
import com.AirMatios.Service.BookingService;
import com.AirMatios.Service.LoginService;
import com.AirMatios.Service.PaymentProxy;
import com.AirMatios.Service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AirMatiosController {

    private final BookingService bookingService;
    private final LoginService loginService;
    private final SearchService searchService;
    private final PaymentProxy paymentProxy;

    public AirMatiosController(BookingService bookingService, LoginService loginService, SearchService searchService, PaymentProxy paymentProxy) {
        this.bookingService = bookingService;
        this.loginService = loginService;
        this.searchService = searchService;
        this.paymentProxy = paymentProxy;
    }

    @GetMapping("/")
    public String homeGet(){
        return "Welcome to our awesome service where You can search / book flights !!";
    }

    @GetMapping("/login")
    public String loginGet(){
        return "Please use Post Mapping with Your credentials";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String login, String password){
        return loginService.logIn(login, password);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserData userData){
        loginService.addUser(userData);
        return "User Added";
    }

    @GetMapping("/Users")
    public Iterable<UserData> showAllUsers(){
        return searchService.showAllUsers();
    }

    @PostMapping("/User")
    public Optional<UserData> findDataAboutUser(@RequestParam String login){
        return searchService.findDataAboutUser(login);
    }

    @PostMapping("search")
    public Iterable<Flight> showFlightByDeparture(@RequestParam String departureCity){
        return searchService.showFlightByDeparture(departureCity);
    }

    @PostMapping("searche")
    public Iterable<Flight> showFlightByPrice(@RequestParam Double price){
        return searchService.showFlightByPrice(price);
    }
    @PostMapping("searcha")
    public Iterable<Flight> showFlightByPriceAndDirection(@RequestParam Double price, String departureCity, String destinationCity){
        return searchService.showFlightByPriceAndDirection(price, departureCity, destinationCity);
    }

    @PostMapping("booking")
    public Iterable<Orders> bookFlight(@RequestParam int flight_ID){
        if(!(loginService.getLoggedUser() == null))
        return bookingService.orderFlight(flight_ID, loginService.getLoggedUser());
        else
            System.out.println("proszę się zalogować");
            return null;
    }

    @GetMapping("payment")
    public void payment(){
        if(!(loginService.getLoggedUser() == null)){
            if(!(bookingService.findOrdersByUser(loginService.getLoggedUser())==null))
                paymentProxy.payment(bookingService.findOrdersByUser(loginService.getLoggedUser()));
            else{
                System.out.println("brak lotów do opłaty");}
        }
        else
            System.out.println("proszę się zalogować");
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
