package com.AirMatios.Service;

import com.AirMatios.Repository.UserData;
import com.AirMatios.Repository.UserDataRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchService {

    private UserDataRepository userDataRepository;

    public SearchService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }


    public Iterable<UserData> showAllUsers(){
        return userDataRepository.findAll();
    }

    public Optional<UserData> findDataAboutUser(String login){
        return userDataRepository.findById(login);
    }

}
