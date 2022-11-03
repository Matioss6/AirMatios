package com.AirMatios.Service;

import com.AirMatios.Repository.UserData;
import com.AirMatios.Repository.UserDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class LoginService {

    private UserDataRepository userDataRepository;

    public LoginService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }


    public UserData addUser(UserData userData) {
        return userDataRepository.addUser(userData);
    }

    public String logIn(String login, String password)
    {
        UserData userdata;
        if(userDataRepository.existsById(login)){
         userdata = userDataRepository.findById(login).orElseThrow(RuntimeException::new);
         boolean logedIn = userdata.getPassword().equals(password);
            if(logedIn)
              return "You are now logged in";
            else
                return "Wrong Password";
        }
        else
            return "No such user exists";
    }
}
