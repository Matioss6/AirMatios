package com.AirMatios.Controllers;

import com.AirMatios.Repository.Orders;
import com.AirMatios.Service.BookingService;
import com.AirMatios.Service.LoginService;
import com.AirMatios.Service.PaymentProxy;
import org.springframework.web.bind.annotation.*;


@RestController
public class AirMatiosController {

    private final BookingService bookingService;
    private final LoginService loginService;
    private final PaymentProxy paymentProxy;

    public AirMatiosController(BookingService bookingService,LoginService loginService, PaymentProxy paymentProxy) {
        this.bookingService = bookingService;
        this.loginService = loginService;
        this.paymentProxy = paymentProxy;
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





}
