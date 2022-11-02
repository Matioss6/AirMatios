package com.AirMatios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirMatiosController {


    @GetMapping("/")
    public String home(){
        return "Welcome to our awesome service where You can search / book flights !!";
    }
}
