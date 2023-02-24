package com.AirMatios.Repository;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Orders {

    @Id
    private int OrderID;
    private String UserLogin;
    private int FlightID;

        public int getOrder_ID() {
        return OrderID;
    }

    public void setOrder_ID(int order_ID) {
        this.OrderID = order_ID;
    }

    public String getUser_Login() {
        return UserLogin;
    }

    public void setUser_Login(String user_Login) {
        this.UserLogin = user_Login;
    }

    public int getFlight_ID() {
        return FlightID;
    }

    public void setFlight_ID(int flight_ID) {
        this.FlightID = flight_ID;
    }
}
