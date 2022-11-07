package com.AirMatios.Repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends CrudRepository<UserData, String> {


    @Query("INSERT INTO User_Data(login,password,first_Name,last_Name) VALUES (:login, :password,:firstName,:lastName)")
    @Modifying
    public void addUser (String login, String password, String firstName, String lastName);

}
