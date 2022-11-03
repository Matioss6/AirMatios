package com.AirMatios.Repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends CrudRepository<UserData, String> {


    @Query("INSERT INTO UserData VALUES (:userData.getLogin(), :userData.getPassword(),:userData.getFirstName(),:userData.getLastName()")
    @Modifying
    public UserData addUser (UserData userData);
}
