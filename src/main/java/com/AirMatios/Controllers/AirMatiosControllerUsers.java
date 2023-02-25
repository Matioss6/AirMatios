package com.AirMatios.Controllers;

import com.AirMatios.Repository.UserData;
import com.AirMatios.Service.LoginService;
import com.AirMatios.Service.SearchService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class AirMatiosControllerUsers {


    private final LoginService loginService;
    private final SearchService searchService;


    public AirMatiosControllerUsers(LoginService loginService, SearchService searchService) {

        this.loginService = loginService;
        this.searchService = searchService;

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





}
