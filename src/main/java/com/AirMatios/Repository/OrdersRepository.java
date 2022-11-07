package com.AirMatios.Repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> {

    @Query("INSERT INTO Orders(User_Login, Flight_ID) VALUES (:login, :flight_ID)")
    @Modifying
    public void addOrder(int flight_ID, String login);

    @Query("SELECT * FROM Orders WHERE User_Login = :login AND Flight_ID = :flight_ID")
    public Iterable<Orders> findOrder(int flight_ID, String login);

    @Query("SELECT * FROM Orders WHERE User_Login = :login ")
    public Iterable<Orders> findOrderByUser(String login);



}
