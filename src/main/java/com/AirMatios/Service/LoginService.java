package com.AirMatios.Service;

import com.AirMatios.Repository.UserData;
import com.AirMatios.Repository.UserDataRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserDataRepository userDataRepository;
    private String loggedUser;

    public LoginService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public String getLoggedUser() {
        return loggedUser;
    }

    public void addUser(UserData userData) {
        userDataRepository.addUser(userData.getLogin(),userData.getPassword(),userData.getFirstName(),userData.getLastName());
        }

    public String logIn(String login, String password)
    {
        UserData userdata;
        if(userDataRepository.existsById(login)){
         userdata = userDataRepository.findById(login).orElseThrow(RuntimeException::new);
         boolean logedIn = userdata.getPassword().equals(password);
            if(logedIn){
                loggedUser=login;
              return "You are now logged in";}
            else
                return "Wrong Password";
        }
        else
            return "No such user exists";
    }
}
