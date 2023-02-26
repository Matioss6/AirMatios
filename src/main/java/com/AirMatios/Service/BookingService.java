package com.AirMatios.Service;

import com.AirMatios.Exceptions.NotEnoughMoneyException;
import com.AirMatios.Repository.Orders;
import com.AirMatios.Repository.OrdersRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private OrdersRepository ordersRepository;

    public BookingService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Iterable<Orders> orderFlight(int flight_ID, String user_login){
        ordersRepository.addOrder(flight_ID,user_login);
        return ordersRepository.findOrder(flight_ID, user_login);
    }

    public Iterable<Orders> findOrdersByUser(String user_Login){
        return ordersRepository.findOrderByUser(user_Login);
    }


}
